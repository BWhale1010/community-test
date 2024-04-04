package com.bw.community.board;

import java.util.ArrayList;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@MapperScan("com.bw.community.board")
public class BoardService {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired BoardDAO boardDAO;

	public ArrayList<BoardDTO> boardList() {
		
		return boardDAO.boardList();
	}

}
