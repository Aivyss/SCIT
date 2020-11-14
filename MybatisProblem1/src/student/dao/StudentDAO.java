package student.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import student.vo.Student;

/**
 * DB관련 처리 클래스
 */
public class StudentDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체
	
	//학생정보 저장
	public boolean insert(Student student) {
		SqlSession ss = null;
		boolean flag = false;
		
		try {
			ss = factory.openSession();
			StudentMapper mapper = ss.getMapper(StudentMapper.class);
			mapper.insert(student);
			ss.commit();
			
			flag = true;
		} catch(Exception e) {
			e.getStackTrace();
		} finally {
			if (ss!=null) ss.close();
		}
		
		return flag;
	}

	//전체 읽기
	public ArrayList<Student> selectAll() {
		SqlSession ss = null;
		ArrayList<Student> list = null;
		
		try {
			ss = factory.openSession();
			StudentMapper mapper = ss.getMapper(StudentMapper.class);
			list = mapper.selectAll();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (ss!=null) ss.close();
		}
		
		return list;
	}

	//학생정보 삭제
	public boolean delete(String id) {
		SqlSession ss = null;
		boolean flag = false;
		
		try {
			ss = factory.openSession();
			StudentMapper mapper = ss.getMapper(StudentMapper.class);
			mapper.delete(id);
			ss.commit();
			
			flag = true;
		} catch (Exception e) {
			
		} finally {
			if (ss!=null) ss.close();
		}
		
		return flag;
		
	}
	
	//학생정보 수정
	public boolean update(Student student) {
		SqlSession ss = null;
		boolean flag = false;
		
		try {
			ss = factory.openSession();
			StudentMapper mapper = ss.getMapper(StudentMapper.class);
			mapper.update(student);
			ss.commit();
			
			flag = true;
		} catch(Exception e) {
			e.getStackTrace();
		} finally {
			if (ss!=null) ss.close();
		}
		
		return flag;
	}
	
	//이름으로 검색
	public ArrayList<Student> selectName(String name) {
		SqlSession ss = null;
		ArrayList<Student> list = null;
		
		try {
			ss = factory.openSession();
			StudentMapper mapper = ss.getMapper(StudentMapper.class);
			list = mapper.selectName(name);
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if(ss!=null) ss.close();
		}
		
		return list;
	}

}
