package com.bw.community.board;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bw.community.user.UserDTO;

@RestController
public class BoardApiController {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired BoardService boardService;
	
	@PostMapping("boardList_1")
	public HashMap<String, Object> boardList_1(@RequestParam int page){
		logger.info("page : "+page);
		
		return boardService.boardList_1(page);
	}
	
	@PostMapping("board/write")
	public HashMap<String, Object> boardWrite(@RequestParam HashMap<String, Object> params, HttpSession session, HttpServletRequest req){
			int userId = (int) session.getAttribute("userId");
			params.put("userId", userId);
			params.put("categoryId", 1);
			logger.info("params : {}",params);
			int row = boardService.write(params);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("success", row);
			
		return map;
		
	}
	
	@PostMapping("board/update/{id}")
	public HashMap<String, Object> boardUpdate(@RequestParam HashMap<String, Object> params,
			@PathVariable("id") int id){
	
			params.put("id", id);
			logger.info("params : {}",params);
			
			int row = boardService.update(params);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("success", row);
			
		return map;
	}
	
	@DeleteMapping("/board/delete/{id}")
	public HashMap<String, Object> boardDelete(@PathVariable("id") int id) {
		logger.info("글 삭제 : "+id);
		int row = boardService.delete(id);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("success", row);
		
		return map;
	}
	

}
