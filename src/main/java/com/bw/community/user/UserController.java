package com.bw.community.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

	@Value("${bw.key}")
	private String bwKey;
	
	@Autowired UserService UserService;
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/loginForm")
	public String loginForm() {
		
		return "/user/loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		
		return "/user/joinForm";
	}
	
	@PostMapping("/login")
	public String login(String username, String password, HttpSession session, 
		HttpServletRequest req, Model model) {
		logger.info("로그인 id : "+username+"password : "+password);
		UserDTO loginId = UserService.login(username, password);
		logger.info("로그인 컨트롤러");
		logger.info("로그인 세션 : "+loginId);
		String page = "redirect:/";
		String msg = "로그인 완료";
		
		
		if(loginId != null) {
			session = req.getSession();
			session.setAttribute("userName", loginId.getUsername());
			session.setAttribute("email", loginId.getEmail());
			session.setAttribute("userId", loginId.getId());
		}else {
			page = "user/loginForm";
			msg = "로그인 실패";
		}
		
		model.addAttribute("msg", msg);
		
		return page;
	}
	
	@GetMapping("/login/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userName");
		session.removeAttribute("email");
		return "redirect:/";
	}
	
	@GetMapping("/user")
	public String user(HttpSession session, Model model) {
		String id = String.valueOf(session.getAttribute("userId"));
		logger.info("회원정보 보기 : "+id);
		
		UserDTO user = UserService.user(id);
		
		model.addAttribute("user", user);
		
		return "user/user";
	}
	


	@ GetMapping("/login/kakao/callback")
	public String kakaoLogin(@RequestParam(value="code", required = false) String code, 
			HttpSession session, Model model, HttpServletRequest req) throws IOException {
		logger.info("code ## :"+code);
		
		HashMap<String, Object> access_Token = UserService.getAccessToken(code);
		UserDTO userInfo = UserService.userInfo(access_Token);
		String username = userInfo.getUsername();
	
		UserDTO loginId = UserService.login(username, bwKey);
		session = req.getSession();
		session.setAttribute("userName", loginId.getUsername());
		session.setAttribute("email", loginId.getEmail());
		session.setAttribute("userId", loginId.getId());
		
		String msg = "로그인 완료";
		
		model.addAttribute("msg", msg);
		
		return "redirect:/";
	}
	
	
	
	
	

	
	
	
	
	
}
