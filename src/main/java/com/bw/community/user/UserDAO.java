package com.bw.community.user;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserDAO {

	ArrayList<UserDTO> userList();

	UserDTO login(String username);

	int join(HashMap<String, String> params);

	String enc_pw(String username);

	UserDTO user(String id);

	int userUpdate(HashMap<String, Object> params);

	UserDTO findkakao(HashMap<String, Object> userInfo);

	void kakaoinsert(HashMap<String, Object> userInfo);

	UserDTO userFind(String id);

	void joinKakao(HashMap<String, Object> userInfo);





}
