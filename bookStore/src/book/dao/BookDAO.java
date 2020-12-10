package book.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import book.vo.BookVO;

/**
 * DB관련 처리 클래스
 */
public class BookDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체
	
	/**
	 * 도서정보 저장
	 * @param vo 저장할 도서 정보
	 * @return 저장된 레코드 수
	 */
	public int insertBook(BookVO vo) {
		SqlSession ss= null;
		int count = 0;
		
		try {
			ss = factory.openSession();
			BookMapper mapper = ss.getMapper(BookMapper.class);
			count = mapper.insertBook(vo);
			
			if (count>0) {
				ss.commit();
			} else {
				ss.rollback();
			}
		} catch (Exception e) {
			ss.rollback();
			count = 0; // 예외 발생으로 인한 처리
		} finally {
			if(ss!=null) ss.close();
		}
		
		return count;
	}

	/**
	 * 전체 도서 목록 읽기
	 * @return 도서 목록
	 */
	public ArrayList<BookVO> listAll() {
		SqlSession ss= null;
		ArrayList<BookVO> list = null;
		
		try {
			ss = factory.openSession();
			BookMapper mapper = ss.getMapper(BookMapper.class);
			
			list = mapper.listAll();
		} catch (Exception e) {
			list = null; // 예외 발생으로 인한 처리
		} finally {
			if(ss!=null) ss.close();
		}
		
		
		return list;
	}
	
	/**
	 * 번호로 삭제하기
	 * @param bnum 삭제할 번호
	 * @return 삭제된 레코드 수
	 */
	public int deleteBook(int bnum) {
		SqlSession ss= null;
		int count = 0;
		
		try {
			ss = factory.openSession();
			BookMapper mapper = ss.getMapper(BookMapper.class);
			
			count = mapper.deleteBook(bnum);
			
			if(count > 0) {
				ss.commit();
			} else {
				ss.rollback();
			}
		} catch (Exception e) {
			ss.rollback();
			count = 0; // 예외 발생으로 인한 처리
		} finally {
			if(ss!=null) ss.close();
		}
		
		return count;
	}
	
	/**
	 * 번호로 도서 정보 수정하기
	 * @param vo 수정할 정보가 담긴 객체
	 * @return 수정된 레코드 수
	 */
	public int updateBook(BookVO vo) {
		SqlSession ss = null;
		int count = 0;
		
		try {
			ss = factory.openSession();
			BookMapper mapper = ss.getMapper(BookMapper.class);
			
			count = mapper.updateBook(vo);
			
			if (count > 0) {
				ss.commit();
			} else {
				ss.rollback();
			}
		} catch (Exception e) {
			ss.rollback();
			count = 0;
		} finally {
			if (ss!=null) ss.close();
		}
		
		return count;
	}
	
	/**
	 * 번호로 도서정보 읽기
	 * @param bnum 검색할 번호
	 * @return 도서 정보 
	 */
	public BookVO getBook(int bnum) {
		SqlSession ss= null;
		BookVO book = null;
		
		try {
			ss = factory.openSession();
			BookMapper mapper = ss.getMapper(BookMapper.class);
			
			book = mapper.getBook(bnum);
		} catch (Exception e) {
			book = null; // 예외 발생으로 인한 처리
		} finally {
			if(ss!=null) ss.close();
		}	
		
		return book;
	}

	
	
	/**
	 * 검색하기
	 * @param text 검색어
	 * @return 검색 결과
	 */
	public ArrayList<BookVO> searchBook(String text) {
		SqlSession ss= null;
		ArrayList<BookVO> list = null;
		
		try {
			ss = factory.openSession();
			BookMapper mapper = ss.getMapper(BookMapper.class);
			
			list = mapper.searchBook(text);
		} catch (Exception e) {
			list = null; // 예외 발생으로 인한 처리
		} finally {
			if(ss!=null) ss.close();
		}
		
		
		return list;
	}
	
	/**
	 * 출판사별 검색하기
	 * @return 검색 결과
	 */
	public ArrayList<BookVO> searchPublisher(){
		SqlSession ss= null;
		ArrayList<BookVO> list = null;
		
		try {
			ss = factory.openSession();
			BookMapper mapper = ss.getMapper(BookMapper.class);
			
			list = mapper.searchPublisher();
		} catch (Exception e) {
			list = null; // 예외 발생으로 인한 처리
		} finally {
			if(ss!=null) ss.close();
		}
		
		
		return list;
	}
}
