package user.vo;

import java.util.HashMap;

//ﾈｸｿ､ｺｸ VO
public class User {
	private String id;			
	private String name;		
	private String gender;		
	private String phone;		
	private String address;		
	
	public User() {
		
		
	}
	
	public User(String id, String name, String gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phone = "";
		this.address = "";
	}
	
	public User(HashMap<String, Object> info) {
		this.id = (String) info.get("id");
		this.name = (String) info.get("name");
		this.gender = (String) info.get("gender");
		this.phone = (String) info.get("phone");
		this.address = (String) info.get("address");
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return id + "\t" + name + "\t" + gender + "\t" + phone + "\t" + address;
	}
	
	
}
