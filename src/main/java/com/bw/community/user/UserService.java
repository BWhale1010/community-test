package com.bw.community.user;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@MapperScan(value= {"com.bw.community.user"})
public class UserService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired UserDAO UserDao;
	@Autowired PasswordEncoder encoder;
	
	@Value("${bw.key}")
	private String bwKey;

	public ArrayList<UserDTO> userList() {

		return UserDao.userList();
	}

	public int join(HashMap<String, String> params) {
		logger.info("회원가입 서비스");
		
		String password = params.get("password");
		String enc_pw = encoder.encode(password);
		params.put("password", enc_pw);
		
		logger.info("params : {}", params);
		
		int row = UserDao.join(params);
	
		logger.info("회원가입 row : "+row);
		
		return row;
	}

	public UserDTO login(String username, String password) {
		logger.info("로그인 서비스");
		UserDTO loginId = null;
		String enc_pw = UserDao.enc_pw(username);
		boolean match = encoder.matches(password, enc_pw);
		logger.info("로그인 서비스2222");
		if(enc_pw != null) {
			if(match == true) {
				loginId =	UserDao.login(username);
			}
		}
		logger.info("로그인 서비스3333");
		logger.info("loginId 서비스 : "+loginId);
		return loginId;
	}

	public UserDTO user(String id) {
		logger.info("회원정보 서비스");
		return UserDao.user(id);
	}

	public int userUpdate(HashMap<String, Object> params) {
		logger.info("회원정보 업데이트 service");
		String password = (String) params.get("password");
		String enc_pw = encoder.encode(password);
		params.put("password", enc_pw);
		int row = UserDao.userUpdate(params);
		return row;
	}

	public HashMap<String, Object> getAccessToken(String code) throws JsonMappingException, JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", "authorization_code");
	    body.add("client_id", "b12bb8f9669ee4ec9b6e64a6ce803d77");
	    body.add("redirect_uri", "http://localhost:8000/login/kakao/callback");
	    body.add("code", code);
	    
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(body, headers);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );
        
        String responseBody = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
        String accessToken = jsonNode.get("access_token").asText();
        
        logger.info("accessToken : "+accessToken);
        
        headers.add("Authorization", "Bearer " + accessToken);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        
        HttpEntity<MultiValueMap<String, String>> kakaoUserInfoRequest = new HttpEntity<>(headers);
        response = rt.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoUserInfoRequest,
                String.class
        );
        
        responseBody = response.getBody();
        jsonNode = objectMapper.readTree(responseBody);
        String id = jsonNode.get("id").asText();
        String nickname = jsonNode.get("properties")
                .get("nickname").asText();
        String email = jsonNode.get("kakao_account")
                .get("email").asText();
        
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("email", email);
		logger.info("id : "+id);
		logger.info("email : "+email);

		return map;
      
	}
	
	public String enc_password(String password) {
		String enc_pw = encoder.encode(password);
		
		return enc_pw;
	}

	public UserDTO userInfo(HashMap<String, Object> userInfo) {
		logger.info("userInfo : " + userInfo);
		
		String id = (String) userInfo.get("id");
		String email = (String) userInfo.get("email");
		String username = id+"_"+email;
		String password = enc_password(bwKey);
	
		logger.info("username : "+username);
		logger.info("email : "+email);
		
		userInfo.put("username", username);
		userInfo.put("oauth", "kakao");
		userInfo.put("password", password);
		
		 UserDTO findInfo = UserDao.userFind(username);
		
		if(findInfo == null) {
			UserDao.joinKakao(userInfo);
		}
		
		return findInfo;
	}






	

}
