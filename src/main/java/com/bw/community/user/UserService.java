package com.bw.community.user;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
@MapperScan(value= {"com.bw.community.user"})
public class UserService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired UserDAO UserDao;
	@Autowired PasswordEncoder encoder;

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
		
		if(enc_pw != null) {
			if(match == true) {
				loginId =	UserDao.login(username);
			}
		}
		
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
	

}
