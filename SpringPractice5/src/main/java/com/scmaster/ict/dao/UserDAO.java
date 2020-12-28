package com.scmaster.ict.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scmaster.ict.vo.UserVo;

@Repository // DAO는 @Repository 어노테이션 필요
public class UserDAO implements UserMapper {
	
	@Autowired // 스프링의 DI에 의해 만들어진 bean 객체와 자동연결 @Inject(자바에서 제공)도 동일기능을 수행
	private SqlSession session;
	
	@Override
	public int insertUser(UserVo vo) {
		int count = 0;
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			count = mapper.insertUser(vo);
			// 이제 커밋은 스프링이 자동으로 한다.
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return count;
	}

	@Override
	public String checkIdDuplicate(String id) {
		String result = "";
		
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			result = mapper.checkIdDuplicate(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
}
