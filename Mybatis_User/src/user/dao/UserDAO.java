package user.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import user.vo.User;

public class UserDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체

	// 회원정보 저장
	public boolean insertUser(User user) {
		SqlSession ss = null;
		boolean flag = false;

		try {
			ss = factory.openSession();
			UserMapper mapper = ss.getMapper(UserMapper.class);

			flag = (!mapper.insertUser(user)) ? false : mapper.insertUser2(user);
			
			if (flag) {
				ss.commit();
			} else {
				ss.rollback();
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (ss != null)
				ss.close();
		}

		return flag;
	}

	// 전체 회원 목록
	public ArrayList<User> listUser() {
		SqlSession ss = null;
		ArrayList<User> list = null;

		try {
			ss = factory.openSession();
			UserMapper mapper = ss.getMapper(UserMapper.class);

			list = mapper.selectAll();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (ss != null)
				ss.close();
		}

		return list;
	}

	// 특정 회원을 검색하는 기능
	public User selectOne(String id) {
		SqlSession ss = null;
		User result = null;

		try {
			ss = factory.openSession();
			UserMapper mapper = ss.getMapper(UserMapper.class);

			result = mapper.selectOne(id);
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (ss != null)
				ss.close();
		}

		return result;
	}

}
