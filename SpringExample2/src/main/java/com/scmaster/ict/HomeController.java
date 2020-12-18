package com.scmaster.ict;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icmaster.ict.vo.Person;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index(int num, String str) {
		System.out.println(num);
		System.out.println(str);
		return "index";
	} 
	
	@RequestMapping(value="/idCheck", method = RequestMethod.GET)
	public String idCheck(String id, Model model) {		
		// 모델 객체는 서버로 데이터를 보낼 때 사용함.
		System.out.println("클라이언트로부터 전달받은 아이디는 : " + id);
		model.addAttribute("checkedId", id);
		
		return "idCheck";
	}
	
	@RequestMapping(value="/input", method = RequestMethod.POST)
	public String input(Person person) { // @RequestParam은 생략된 것이고 그냥 하면 복잡한 세부설정도 해야함
		// post 메소드로 전송될 때 인풋 태그는 name에 적힌 벨류와 동일하게
		// 매개변수를 넣어야 한다.
		
		// 이건 이전방식
//		System.out.println("Name: " + name);
//		System.out.println("Age: " + age);
//		System.out.println("Address: " + address);
		
		// 이건 신방식
		System.out.println(person);
		
		// return에 바로 주소를 적으면 forward
		return "home";
		
		// return에 redirect:하고 주소를 적으면 redirect 
		//return "redirect:/";
	}
	
}
