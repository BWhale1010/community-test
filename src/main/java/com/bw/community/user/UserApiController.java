package com.bw.community.user;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired UserService userService;
	
	@PostMapping("/join")
	public HashMap<String, Object> join(@RequestParam HashMap<String, String> params){
		logger.info("params : {}", params);
		
		int row = userService.join(params);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("success", row);
		
		return map;
	}
	
	@PutMapping("/userUpdate")
	public HashMap<String, Object> userUpdate(HttpSession session, @RequestParam HashMap<String, Object> params){
			int id = (int) session.getAttribute("userId");
			params.put("id", id);
			logger.info("params : ",params);
			
			int row = userService.userUpdate(params);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("success", row);
		
		return map;
	}
}
