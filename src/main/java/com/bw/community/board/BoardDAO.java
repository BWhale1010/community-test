package com.bw.community.board;

import java.util.ArrayList;
import java.util.HashMap;

public interface BoardDAO {

	int totalCount_1();

	ArrayList<BoardDTO> boardList_1(int offset);

	ArrayList<BoardDTO> boardList();

	BoardDTO boardDetail(int id);

	int write(HashMap<String, Object> params);

	int update(HashMap<String, Object> params);

	int delete(int id);

	int replyWrite(HashMap<String, Object> params);

	ArrayList<ReplyDTO> reply(int id);

	int replyDelete(int id);





}
