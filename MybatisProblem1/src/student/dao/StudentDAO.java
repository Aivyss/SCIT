package student.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import student.vo.Student;

/**
 * DB관련 처리 클래스
 */
public class StudentDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체
	int insertCount = 0; // 입력 되었는지 여부를 판단하기 위한 카운터
	int delCount = 0; // 삭제 되었는지 여부를 판단하기 위한 카운터
	int updateCount = 0; // 업뎃 되었는지 여부를 판단하기 위한 카운터
	
	//학생정보 저장
	public boolean insert(Student student) {
		SqlSession ss = null;
		boolean flag = false;
		
		try {
			ss = factory.openSession();
			StudentMapper mapper = ss.getMapper(StudentMapper.class);
			if (insertCount+1 == mapper.insert(student)) {
				ss.commit();
				flag = true;
			}
		} catch(Exception e) {
			e.getStackTrace();
		} finally {
			if (ss!=null) ss.close();
		}
		
		return flag;
	}

	//전체 읽기
	public List<Student> selectAll() {
		SqlSession ss = null;
		List<Student> list = null;
		
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
			if (mapper.delete(id) == delCount +1) {
				ss.commit();
				flag = true;				
			}
		} catch (Exception e) {
			e.getStackTrace();
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
	public List<Student> selectName(String name) {
		SqlSession ss = null;
		List<Student> list = null;
		
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
