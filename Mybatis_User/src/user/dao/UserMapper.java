package user.dao;

import java.util.ArrayList;
import java.util.HashMap;

import user.vo.User;

/**
 * Mapper XML의 SQL문 사용 메서드
 */
public interface UserMapper {
	//회원 정보 저장
	public boolean insertUser(User user);
	//회원 정보 중 추가 정보 저장
	public boolean insertUser2(User user);
	//회원 목록 
	public ArrayList<User> selectAll();
	//회원 검색
	public User selectOne(String id);
}
