package board.mgr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.dao.BoardDAO;
import board.vo.Board;

public class BoardManager {
	
	private BoardDAO dao = new BoardDAO();
	
	public boolean insertBoard(Board board) {
		return dao.insertBoard(board);
	}

	public List<Board> listBoard() {
		return dao.listBoard();
	}
	
	public Board readBoard(int num) {
		return dao.readBoard(num);
	}
	
	public boolean deleteBoard(int num) {
		return dao.deleteBoard(num);
	}

	public List<Board> searchBoard(int selector, String word) { // 동적쿼리?
		Map<String, Object> param = new HashMap<>();
		
		param.put("s", selector);
		param.put("w", word);
		
		return dao.searchBoard(param);
	}
}
