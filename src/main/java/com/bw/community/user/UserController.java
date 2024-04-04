package com.bw.community.user;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@Autowired UserService UserService;
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/loginForm")
	public String loginForm() {
		
		return "/user/loginForm";
	}
	
	@RequestMapping(value = "/user")
	public String main(Model model) {
	
		ArrayList<UserDTO> userList = UserService.userList();
		logger.info("회원 리스트 개수 : "+userList.size());
		
		model.addAttribute("userList", userList);
	
		return "user";
	}
	
	
}
