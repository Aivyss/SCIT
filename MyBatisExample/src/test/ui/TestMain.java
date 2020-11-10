package test.ui;

import java.util.ArrayList;

import test.dao.PersonDAO;
import test.vo.Person;

public class TestMain {

	public static void main(String[] args) {
		
		PersonDAO dao = new PersonDAO();
		
		Person pe;
		
		//입력
		pe = new Person("김철수", 30);
		dao.insertPerson(pe);
		

		
	}
}