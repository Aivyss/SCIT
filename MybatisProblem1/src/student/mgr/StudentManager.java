package student.mgr;

import java.util.ArrayList;

import student.dao.StudentDAO;
import student.vo.Student;

public class StudentManager {
	StudentDAO dao = new StudentDAO();
	
	/**
	 * 학생정보를 DB에 저장하는 메소드
	 * @param s
	 * @return
	 */
	public boolean insert(Student s) {
		return dao.insert(s);
	}

	/**
	 * 모든 학생 리스트를 추출하는 메소드
	 * @return
	 */
	public ArrayList<Student> selectAll() {
		return dao.selectAll();
	}

	/**
	 * 학생 정보를 삭제하는 메소드
	 * @param id
	 * @return
	 */
	public boolean delete(String id) {
		return dao.delete(id);
	}
	
	/**
	 * 학생 정보를 수정하는 메소드
	 * @param s
	 * @return
	 */
	public boolean update(Student s) {
		return dao.update(s);
	}
	
	/**
	 * 이름과 일치하는 학생의 리스트를 뽑음.
	 * 동명이인이 있을 수 있으므로 리턴값은 리스트이다.
	 * @param name
	 * @return
	 */
	public ArrayList<Student> selectName(String name) {
		return dao.selectName(name);
	}
	
}
