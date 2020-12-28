package com.scmaster.ict.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scmaster.ict.service.UserService;
import com.scmaster.ict.vo.UserVo;

@Controller
@RequestMapping(value="/user")
public class UserViewController {
		private static final Logger logger = LoggerFactory.getLogger(UserViewController.class);
		// 서버가 없으니 임시로 만든 어레이리스트
		ArrayList<UserVo> list = new ArrayList<UserVo>();
		
		//진짜 서버는 이것.
		@Autowired
		private UserService service;
		
		@RequestMapping(value="/joinForm",  method = RequestMethod.GET)
		public String joinForm() {
			logger.info("회원가입 폐이지로 이동");
			
			return "user/joinForm";
		}
		
		@RequestMapping(value="/join" , method= RequestMethod.POST)
		public String join(UserVo vo) {
			logger.info("회원가입");
			
			return service.insertUser(vo);
		}
		
		@RequestMapping(value="/logInForm", method = RequestMethod.GET)
		public String logInForm(HttpServletRequest request, Model model) {
			logger.info("로그인 페이지로 이동");
			
			// 사용자 쪽에 놓은 쿠키가 있는지 확인하는 프로세스 쿠키는 리퀘스트 안에 포함되어 있다.
			Cookie[] cookies = request.getCookies();
			
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("cookieId".equals(cookie.getName())) {
						model.addAttribute("id", cookie.getValue()); // jsp 변수를 만드는 것과 같은가?
					}
				}
			}
			
			return "user/logInForm"; // view -> user -> [logInForm.jsp]
		}
		
		@RequestMapping(value="/logIn", method=RequestMethod.POST)
		public String logIn(UserVo user, HttpSession session, boolean loginCheck, HttpServletResponse response) { // HttpSession -> 세션스코프!
			
			for (UserVo item : list) {
				if (item.getId().equals(user.getId())) {
					if (item.getPw().equals(user.getPw())) {
						// 로그인 검증 후 승인~
						// session scope에 login 성공한 유저의 id를 저장하는 것
						logger.info("로그인 처리");
						session.setAttribute("loginId", user.getId());
						session.setAttribute("loginName", item.getName());
						
						Cookie c = new Cookie("id ", user.getId());
						if (loginCheck) { // 아이디 기억하기를 선택한 상황
							c.setMaxAge(60*60*24*90); // 쿠키의 생명주기 지정
						} else { // 아이디 기억하기를 선택하지 않은 상황.
							c.setMaxAge(0);
						}
						response.addCookie(c);
					}
				}
			}
			
			return "redirect:/"; // 세션에 데이터를 넣기 때문에 포워드를 쓰지 않는다. 
		}
		
		@RequestMapping(value="/logOut", method=RequestMethod.GET)
		public String logOut(HttpSession session) {
			session.removeAttribute("loginId");
			session.invalidate(); // 세션스코프 전체를 싹다 지움
			
			return "redirect:/";
		}

}
