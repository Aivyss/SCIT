package com.scmaster.ict.dao;

import com.scmaster.ict.vo.UserVo;

public interface UserMapper {
	
	public int insertUser(UserVo vo);
	public String checkIdDuplicate(String id);
}
