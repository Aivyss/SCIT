package board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.vo.Board;

public class BoardDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // ���̹�Ƽ�� ��ü

	// �� ����
	public boolean insertBoard(Board board) {
		SqlSession ss = null;
		boolean flag = false;

		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			
			if (mapper.insertOne(board)) {
				flag = true;
				ss.commit();
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (ss != null) ss.close();
		}
		
		return flag;
	}
	
	
	
	

	public List<Board> listBoard() {
		SqlSession ss = null;
		List<Board> list = null;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			
			list = mapper.selectTitles();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(ss!=null) ss.close();
		}
		
		return list;
	}
	
	
	

	public Board readBoard(int num) {
		SqlSession ss = null;
		Board vo = null;
		try {
			ss = factory.openSession();
			BoardMapper mapp = ss.getMapper(BoardMapper.class);
			
			vo = mapp.searchNum(num);
			
			if (vo !=null) {
				mapp.increaseHits(vo);
				ss.commit();
				vo.setHits(vo.getHits()+1);
			c
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if(ss!=null) ss.close();
		}
		
		return vo;
	}

	
	
	public boolean deleteBoard(int num) {
		SqlSession ss = null;
		boolean flag = false; 
		
		try {
			ss = factory.openSession();
			BoardMapper mapp = ss.getMapper(BoardMapper.class);
			
			if (mapp.deleteOne(num)) {
				ss.commit();
				flag = true;
			} else {
				ss.rollback();
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if(ss!=null) ss.close();
		}
		
		return flag;
	}
	
	
	

	public List<Board> searchBoard(Map<String, Object> param) {
		SqlSession ss = null;
		List<Board> list = null;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			
			list = mapper.searchTitle(param);
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if(ss!=null) ss.close();
		}
		
		return list;
	}

}
