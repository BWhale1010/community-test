package com.bw.community.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

	public HashMap<String, Object> boardList_1(int page) {
		int offset = (page-1)*10;
		int totalCount = boardDAO.totalCount_1();
		int totalPages = totalCount%10>0?(totalCount/10)+1:(totalCount/10);
		
		logger.info("총 페이지 수 : {}",totalPages);
		HashMap<String, Object> result = new HashMap<String, Object>();
		ArrayList<BoardDTO> list = boardDAO.boardList_1(offset);
		
		result.put("total", totalPages);
		result.put("list", list);
		
		return result;
	}

	public BoardDTO boardDetail(int id) {
		logger.info("board 상세보기 Service");
		return boardDAO.boardDetail(id);
	}

	public int write(HashMap<String, Object> params) {
		logger.info("board 쓰기 Service");
		
		int row = boardDAO.write(params);
		return row;
	}

	public int update(HashMap<String, Object> params) {
		int row = boardDAO.update(params);
		return row;
	}

	public int delete(int id) {
		logger.info("board 삭제 Service");
		
		int row =  boardDAO.delete(id);
		
		return row;
	}


	






}
