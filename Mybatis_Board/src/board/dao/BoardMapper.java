package board.dao;

import java.util.ArrayList;
import java.util.List;

import board.vo.Board;

/**
 * Mapper XML의 SQL문 사용 메서드
 */
public interface BoardMapper {
	//글 저장
	public boolean insertOne(Board board);
	//글 목록
	public List<Board> selectTitles();
	//글 읽기
	public Board searchNum(int boardnum);
	//글의 조회수 증가
	public boolean increaseHits(Board board);
	//글 삭제
	public boolean deleteOne(int boardNum);
	//글 검색	
	public List<Board> searchTitle(String title);
}
