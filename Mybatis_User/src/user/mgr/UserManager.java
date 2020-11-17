package user.mgr;

import java.util.ArrayList;

import user.dao.UserDAO;
import user.vo.User;

public class UserManager {
	private UserDAO dao = new UserDAO();			
		
	//회원정보 저장
	public boolean insertUser(User user) {
		User searched = dao.selectOne(user.getId());
		boolean flag = false;
		
		if (searched == null) {
			flag = dao.insertUser(user);
		}
		
		return flag;
	}

	//전체 회원 목록
	public ArrayList<User> listUser() {
		return dao.listUser();
	}
	
	// 회원 찾기 목록
	public User searchUser(String id) {
		return dao.selectOne(id);
	}
}
