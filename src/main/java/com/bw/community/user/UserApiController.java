package com.bw.community.user;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired UserService userService;
	
	@PostMapping("/join")
	public HashMap<String, Object> join(@RequestParam HashMap<String, String> params){
		logger.info("params : {}", params);
		
		String username = params.get("username");
		String email = params.get("email");
		String password = params.get("password");
		
		int row = userService.join(username, email, password);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("success", row);
		
		return map;
	}
}