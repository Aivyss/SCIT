package student.dao;

import java.util.ArrayList;
import java.util.List;

import student.vo.Student;

/**
 * Mapper XML의 SQL문 사용 메서드 정의
 */
public interface StudentMapper {
	//Student 객체 저장
	public int insert(Student student);
	//전체 읽기
	public List<Student> selectAll();
	//삭제
	public int delete(String id);
	//수정
	public int update(Student student);
	//이름으로 검색
	public List<Student> selectName(String name);

}
