package com.scmaster.ict.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scmaster.ict.dao.UserDAO;
import com.scmaster.ict.vo.UserVo;

@Service // 서비스는 @Service 어노테이션 필요
public class UserService { // 비즈니스 로직을 실시하는 부분, 예전 매니저 부분
	
	// DAO도 bean 객체로 등록되어 있어서 따로 생성하지 않아도 된다.
	@Autowired
	private UserDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public String insertUser(UserVo vo) {
		int count = dao.insertUser(vo);
		String root = "";
		
		if (count > 0) {
			logger.info("Sign in Success");
			root = "redirect:/";
		} else {
			logger.info("Sign in Fail");
			root = "redirect:/user/joinForm";
		}
		
		return root;
	}
	
	public boolean checkIdDuplicate(String id) {
		boolean flag = true;
		
		if (dao.checkIdDuplicate(id) == id) {
			flag = false; // 사용불가
		}
		
		return flag;
	}
}
