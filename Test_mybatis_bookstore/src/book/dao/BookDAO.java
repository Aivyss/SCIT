package book.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import book.vo.BookVO;

/**
 * DB���� ó�� Ŭ����
 */
public class BookDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // ���̹�Ƽ�� ��ü
	
	/**
	 * �������� ����
	 * @param vo ������ ���� ����
	 * @return ����� ���ڵ� ��
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
			count = 0; // ���� �߻����� ���� ó��
		} finally {
			if(ss!=null) ss.close();
		}
		
		return count;
	}

	/**
	 * ��ü ���� ��� �б�
	 * @return ���� ���
	 */
	public ArrayList<BookVO> listAll() {
		SqlSession ss= null;
		ArrayList<BookVO> list = null;
		
		try {
			ss = factory.openSession();
			BookMapper mapper = ss.getMapper(BookMapper.class);
			
			list = mapper.listAll();
		} catch (Exception e) {
			list = null; // ���� �߻����� ���� ó��
		} finally {
			if(ss!=null) ss.close();
		}
		
		
		return list;
	}
	
	/**
	 * ��ȣ�� �����ϱ�
	 * @param bnum ������ ��ȣ
	 * @return ������ ���ڵ� ��
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
			count = 0; // ���� �߻����� ���� ó��
		} finally {
			if(ss!=null) ss.close();
		}
		
		return count;
	}
	
	/**
	 * ��ȣ�� ���� ���� �����ϱ�
	 * @param vo ������ ������ ��� ��ü
	 * @return ������ ���ڵ� ��
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
	 * ��ȣ�� �������� �б�
	 * @param bnum �˻��� ��ȣ
	 * @return ���� ���� 
	 */
	public BookVO getBook(int bnum) {
		SqlSession ss= null;
		BookVO book = null;
		
		try {
			ss = factory.openSession();
			BookMapper mapper = ss.getMapper(BookMapper.class);
			
			book = mapper.getBook(bnum);
		} catch (Exception e) {
			book = null; // ���� �߻����� ���� ó��
		} finally {
			if(ss!=null) ss.close();
		}	
		
		return book;
	}

	
	
	/**
	 * �˻��ϱ�
	 * @param text �˻���
	 * @return �˻� ���
	 */
	public ArrayList<BookVO> searchBook(String text) {
		SqlSession ss= null;
		ArrayList<BookVO> list = null;
		
		try {
			ss = factory.openSession();
			BookMapper mapper = ss.getMapper(BookMapper.class);
			
			list = mapper.searchBook(text);
		} catch (Exception e) {
			list = null; // ���� �߻����� ���� ó��
		} finally {
			if(ss!=null) ss.close();
		}
		
		
		return list;
	}
	
	/**
	 * ���ǻ纰 �˻��ϱ�
	 * @return �˻� ���
	 */
	public ArrayList<BookVO> searchPublisher(){
		SqlSession ss= null;
		ArrayList<BookVO> list = null;
		
		try {
			ss = factory.openSession();
			BookMapper mapper = ss.getMapper(BookMapper.class);
			
			list = mapper.searchPublisher();
		} catch (Exception e) {
			list = null; // ���� �߻����� ���� ó��
		} finally {
			if(ss!=null) ss.close();
		}
		
		
		return list;
	}
}
