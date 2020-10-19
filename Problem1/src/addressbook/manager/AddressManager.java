package addressbook.manager;

import java.util.ArrayList;
import java.util.List;

import addressbook.vo.AddressVO;

/**
 * 주소 정보 처리 클래스.
 * 등록, 검색, 파일 입출력 등의 기능을 수행
 */
public class AddressManager {
	List<AddressVO> list;
	
	/**
	 * 기본 생성자 - 빈 리스트를 생성
	 */
	public AddressManager() {
		this.list = new ArrayList<AddressVO>();
	}
	
	/**
	 * 전달된 새 주소를 리스트에 등록한다.
	 * @param vo 등록할 정보를 담은 객체
	 */
	public void addAddress(AddressVO vo) {
		this.list.add(vo);
	}
	
	/**
	 * 전체 주소 정보 리스트를 리턴한다.
	 * @return 주소정보 객체들이 저장된 리스트
	 */
	public List<AddressVO> getList() {
		return this.list;
	}
	
	/**
	 * 이름으로 주소 정보 검색
	 * @param name 검색할 이름
	 * @return	검색된 객체 또는 없으면 null
	 */
	public AddressVO getAddress(String name) {
		AddressVO vo = null;
		
		if (getList().size() == 0) {
			vo = null; // 검색결과가 없음
		}
		
		for (AddressVO search : this.list) {
			if(name.equals(search.getName())){
				vo = search;
				break; //검색결과 도출
			}
		}
			
		return vo; 
	}

	/**
	 * 그룹으로 주소 정보 검색
	 * @param group 검색할 그룹
	 * @return 검색된 객체들을 담은 리스트
	 */
	public List<AddressVO> getGroupList(String group) {
		List<AddressVO> search = new ArrayList<>();
		
		for (AddressVO vo : this.list) {
			if(group.equals(vo.getGroup())) {
				search.add(vo);
			}
		}
		
		return search;
	}

	/**
	 * 이름으로 주소 정보 삭제
	 * @param name 삭제할 이름
	 * @return 삭제 성공 여부
	 */
	public boolean removeAddress(String name) {
		boolean flag = false; // 조건문에서 걸리지 않을 시 삭제할 데이터가 없음을 의미
		
		for (int i=0; i<getList().size(); i++) {
			AddressVO vo = getList().get(i);
			if (vo.getName().equals(name)) {
				list.remove(i);
				flag = true; // 삭제할 데이터가 있음을 의미
			}
		}		
		
		return flag;
	}
}