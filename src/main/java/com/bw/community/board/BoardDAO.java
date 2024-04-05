package com.bw.community.board;

import java.util.ArrayList;

public interface BoardDAO {

	int totalCount();

	ArrayList<BoardDTO> mainList(int offset);

	ArrayList<BoardDTO> boardList();



}
