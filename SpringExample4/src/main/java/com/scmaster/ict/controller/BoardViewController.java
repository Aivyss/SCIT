package com.scmaster.ict.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scmaster.ict.vo.BoardVO;

@Controller
@RequestMapping(value="/board")
public class BoardViewController {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BoardViewController.class);
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		logger.info("1. 게시판 목록페이지로 이동");
		logger.info("2. DB에서 게시판 목록 조회후 이동");
		
		// 서버에서 가져왔다고 가정하는 부분
		List<String> list = new ArrayList<String>();	
		list.add("1번째 글");
		list.add("2번째 글");
		list.add("3번째 글");
		list.add("4번째 글");
		list.add("5번째 글");
		// 서버에서 가져왔다고 가정하는 부분
		
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping(value="/writeForm", method=RequestMethod.GET)
	public String boardWriteForm() {
		logger.info("글쓰기 폼으로 이동");
		
		return "board/writeForm";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String boardWrite(BoardVO board) {
		logger.info("전달 받은 데이터{} 두부에 등록한다.", board);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value= "/read", method=RequestMethod.GET)
	public String boardUpdateHits(int board_no) {
		logger.info("조회수를 증가 (update) 시켜줘야 한다.");
		return "redirect:/board/read/readContent?board_no=" + board_no;
	}
	
	@RequestMapping(value="/readCount", method=RequestMethod.GET)
	public String boardReadContent(int board_no, Model model) {
		logger.info("전달받은 글번호 {}를 가지고 DB에가서 글을 조회한다.", board_no);
		model.addAttribute("board", "글의상세정보");
		
		return "";
	}
}
