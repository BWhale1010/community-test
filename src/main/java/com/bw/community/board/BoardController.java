package com.bw.community.board;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping({"","/"})
	public String main(Model model) {
		ArrayList<BoardDTO> boardList = boardService.boardList();
		
		logger.info("게시판 글 개수 : "+boardList.size());
		model.addAttribute("boardList", boardList);
		
		return "main";
	}
}
