package book.dao;

import java.util.ArrayList;

import book.vo.BookVO;

/**
 * Mapper XML�� ���εǴ� �������̽�
 */
public interface BookMapper {
	//���� ���� ����
	public int insertBook(BookVO book);

	//��ü ���� ��� �б�
	public ArrayList<BookVO> listAll();
	
	//��ȣ�� �����ϱ�
	public int deleteBook(int bnum);
	
	//��ȣ�� ����, ����, ���ǻ�, ���� �����ϱ�
	public int updateBook(BookVO vo);

	//��ȣ�� �������� �б�
	public BookVO getBook(int bnum);
	
	
	
	//�˻��ϱ�
	public ArrayList<BookVO> searchBook(String text);
	
	//���ǻ纰 �˻�
	public ArrayList<BookVO> searchPublisher();
}
