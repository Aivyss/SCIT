package addressbook.vo;

/**
 * 개인의 이름, 전화번호 등의 정보를 가지는 VO 클래스
 * 생성자, Getters, Setters, toString() 등의 메소드를 정의해서 사용
 */
public class AddressVO {
	private String name;				//이름
	private String group;				//분류 그룹
	private String phone;				//전화번호
	private String address;				//주소
	private String email;				//E-mail 주소
	
	/**
	 * 기본 생성자
	 */
	public AddressVO() {
		
	}
	
	// Setter Getter
	public void setName(String name) {
		this.name = name;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getGroup() {
		return group;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		
		buf.append("이름: ");
		buf.append(getName());
		buf.append(", ");
		buf.append("그룹: ");
		buf.append(getGroup());
		buf.append(", ");
		buf.append("전화: ");
		buf.append(getPhone());
		buf.append(", ");
		buf.append("주소: ");
		buf.append(getAddress());
		buf.append(", ");
		buf.append("Email: ");
		buf.append(getEmail());
		
		return buf.toString();
	}
}