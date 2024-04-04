package com.bw.community.user;

import java.util.ArrayList;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@MapperScan(value= {"com.bw.community.user"})
public class UserService {
	
	@Autowired UserDAO UserDao;

	public ArrayList<UserDTO> userList() {

		return UserDao.userList();
	}
	

}
