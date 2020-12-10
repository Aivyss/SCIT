package book.mgr;

import java.util.ArrayList;

import book.dao.BookDAO;
import book.vo.BookVO;

public class BookManager {
	
	BookDAO dao = new BookDAO();
	
	/**
	 * �������� ����
	 * @param vo ������ ���� ����
	 * @return ���� ���� ����
	 */
	public boolean insertBook(BookVO vo) {
		return (dao.insertBook(vo)>0) ? true : false;
	}

	/**
	 * ��ü ���� ��� �б�
	 * @return ���� ���
	 */
	public ArrayList<BookVO> listAll() {
		return dao.listAll();
	}
	
	/**
	 * ��ȣ�� �������� �б�
	 * @param bnum �˻��� ��ȣ
	 * @return ���� ���� 
	 */
	public BookVO getBook(int bnum) {
		return dao.getBook(bnum);
	}

	/**
	 * ��ȣ�� �����ϱ�
	 * @param bnum ������ ��ȣ
	 * @return ���� ���� ����
	 */
	public boolean deleteBook(int bnum) {
		return (dao.deleteBook(bnum) > 0) ? true : false;
	}
	
	/**
	 * ��ȣ�� ���� ���� �����ϱ�
	 * @param vo ������ ������ ��� ��ü
	 * @return ���� ���� ����
	 */
	public boolean updateBook(BookVO vo) {
		return (dao.updateBook(vo) > 0) ? true : false;
	}
	
	/**
	 * �˻��ϱ�
	 * @param text �˻���
	 * @return �˻� ���
	 */
	public ArrayList<BookVO> searchBook(String text) {
		return dao.searchBook(text);
	}
	
	/**
	 * ���ǻ纰 �˻��ϱ�
	 * @return �˻� ���
	 */
	public ArrayList<BookVO> searchPublisher(){
		return dao.searchPublisher();
	}
}
