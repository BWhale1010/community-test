package com.bw.community.board;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("bdListForm_1")
	public String board1Form() {

		return "board/bdListForm_1";
	}
	
	@GetMapping("board/detail/{id}")
	public String detail(@PathVariable("id") int id, Model model, HttpSession session) {
		logger.info("게시판 id : "+id);
		
		model.addAttribute("boardDetail", boardService.boardDetail(id));
		 
		return "board/detail";
	}
	
	@GetMapping("board/writeForm")
	public String writeForm(HttpSession session, Model model) {
		String page = "board/writeForm";
		String msg = "";
		if(session.getAttribute("userId") == null) {
			page = "/user/loginForm";
			msg = "로그인이 필요합니다.";
		}
		
		model.addAttribute("msg", msg);
		
		return page;
	}
	
	@GetMapping("/board/updateForm/{id}")
	public String updateForm(@PathVariable("id") int id, Model model) {
		logger.info("게시판  수정 : "+id);
		model.addAttribute("boardDetail",  boardService.boardDetail(id));
		return "board/update";
	}
		
		
}
