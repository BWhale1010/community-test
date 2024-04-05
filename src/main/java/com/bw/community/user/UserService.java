package com.bw.community.user;

import java.util.ArrayList;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@MapperScan(value= {"com.bw.community.user"})
public class UserService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired UserDAO UserDao;

	public ArrayList<UserDTO> userList() {

		return UserDao.userList();
	}

	public int join(String username, String email, String password) {
		logger.info("회원가입 서비스");
		
		int row = UserDao.join(username, email, password);
	
		logger.info("회원가입 row : "+row);
		
		return row;
	}

	public String login(String username, String password) {
		logger.info("로그인 서비스");
		
		return UserDao.login(username, password);
	}
	

}
