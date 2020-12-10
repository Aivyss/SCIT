package book.dao;

import java.util.ArrayList;

import book.vo.BookVO;

/**
 * Mapper XML과 매핑되는 인터페이스
 */
public interface BookMapper {
	//도서 정보 저장
	public int insertBook(BookVO book);

	//전체 도서 목록 읽기
	public ArrayList<BookVO> listAll();
	
	//번호로 삭제하기
	public int deleteBook(int bnum);
	
	//번호로 제목, 저자, 출판사, 가격 수정하기
	public int updateBook(BookVO vo);

	//번호로 도서정보 읽기
	public BookVO getBook(int bnum);
	
	
	
	//검색하기
	public ArrayList<BookVO> searchBook(String text);
	
	//출판사별 검색
	public ArrayList<BookVO> searchPublisher();
}
