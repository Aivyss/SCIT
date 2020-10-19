package addressbook.manager;

import java.util.ArrayList;

import addressbook.vo.AddressVO;

/**
 * 주소 정보 처리 클래스.
 * 등록, 검색, 파일 입출력 등의 기능을 수행
 */
public class AddressManager {
	ArrayList<AddressVO> list;
	
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
	public ArrayList<AddressVO> getList() {
		return this.list;
	}
	
	/**
	 * 이름으로 주소 정보 검색
	 * @param name 검색할 이름
	 * @return	검색된 객체 또는 없으면 null
	 */
	public AddressVO getAddress(String name) {
		if (getList().size() == 0) {
			return null;
		}
		for (int i=0; i<getList().size(); i++) {
			AddressVO vo = getList().get(i);
			if (vo.getName().equals(name)) {
				return vo; // 검색결과가 나오면 AddressVO 객체 반환후 종료
			}
		}
		return null; // 검색결과가 없는 경우
	}

	/**
	 * 그룹으로 주소 정보 검색
	 * @param group 검색할 그룹
	 * @return 검색된 객체들을 담은 리스트
	 */
	public ArrayList<AddressVO> getGroupList(String group) {
		ArrayList<AddressVO> search = new ArrayList<>();
		for (int i=0; i<getList().size(); i++) {
			AddressVO vo = getList().get(i);
			if (vo.getGroup().equals(group)) {
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
		boolean flag = false;
		for (int i=0; i<getList().size(); i++) {
			AddressVO vo = getList().get(i);
			if (vo.getName().equals(name)) {
				list.remove(i);
				flag = true;
			}
		}		
		return flag;
	}
}