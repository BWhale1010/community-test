package com.bw.community.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

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
	
	

	
	
	
	
	
}
