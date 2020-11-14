package student.dao;

import java.util.ArrayList;

import student.vo.Student;

/**
 * Mapper XML의 SQL문 사용 메서드 정의
 */
public interface StudentMapper {
	//Student 객체 저장
	public boolean insert(Student student);
	//전체 읽기
	public ArrayList<Student> selectAll();
	//삭제
	public boolean delete(String id);
	//수정
	public boolean update(Student student);
	//이름으로 검색
	public ArrayList<Student> selectName(String name);

}
