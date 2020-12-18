package com.scmaster.ict.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scmaster.ict.vo.UserVO;

@Controller
@RequestMapping(value="/user")
public class UserViewController {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserViewController.class);
	
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public String joinFrom() {
		logger.info("회원가입페이지로 이동");
		return "user/join";
	}
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVO user) {
		logger.info("회원가입을 시행 {}", user);
		
		return "redirect:joinComplete"; // 상대경로로 궈궈
	}
	@RequestMapping(value="/joinComplete", method=RequestMethod.GET)
	public String joinComplete() {
		return "user/SignUpComplete"; // 절대경로로 궈궈
	}
}
