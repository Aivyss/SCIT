package global.sesoc.manager;

import java.util.List;

import global.sesoc.vo.Toy;

public interface ToyManager {

	/**
	 * 제품의 일련 번호를 이용해 해당하는 제품이 있는지 찾는다.
	 * @param serialNum 제품번호
	 * @return 제품번호에 의해 검색된 제품 정보, 검색된 내용이 없을 경우 null이 리턴된다.
	 */
	public Toy searchToy(String serialNum);

	/**
	 * 전달받은 Toy 객체를 List에 추가
	 * @param list에 추가할 Toy객체
	 * @return boolean 추가여부(추가 성공 시 true, 추가 실패시 false) 
	 */
	public boolean insertToy(Toy toy);
	
	/**
	 * 제품 번호를 이용해 해당 제품을 찾았을 경우 제품을 목록에서 삭제하고  true를 리턴한다.
	 * 제품번호를 찾지 못했을 경우 false를 리턴한다.
	 * @param serialNum 삭제할 제품 번호
	 * @return boolean 삭제 여부 리턴 (삭제 완료 시 true, 삭제 실패 시 false)
	 */
	public boolean deleteToy(String serialNum);
	
	/**
	 * 제품 번호와 가격이 포함된 Toy객체를 전달받아 리스트에서 찾아 가격을 수정한다.
	 * @param toy 수정할 정보가 포함된 객체
	 * @return 수정 완료 여부
	 */
	public boolean updateToy(Toy toy);
	
	/**
	 * 최소금액과, 최대금액을 전달받아 해당하는 값을 전달받아 그 영역사이의 가격인 장난감을 리턴한다.
	 * @param 최소값, 최대값
	 * @return 지정한 금액 안에 존재하는 장난감의 목록
	 */
	public List<Toy> toyListForPrice(int minPrice, int maxPrice);
	
	/**
	 * 전달된 타입의 장난감 목록을 출력한다.
	 * @param 장난감 타입
	 * @return List<Toy> 검색된 장난감 목록
	 */
	public List<Toy> groupSearch(int type);
}