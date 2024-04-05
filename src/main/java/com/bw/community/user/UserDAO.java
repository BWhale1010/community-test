package com.bw.community.user;

import java.util.ArrayList;

public interface UserDAO {

	ArrayList<UserDTO> userList();

	int join(String username, String email, String password);

	String login(String username, String password);





}
