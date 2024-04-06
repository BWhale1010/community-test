package com.bw.community.user;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserDAO {

	ArrayList<UserDTO> userList();

	UserDTO login(String username);

	int join(HashMap<String, String> params);

	String enc_pw(String username);





}
