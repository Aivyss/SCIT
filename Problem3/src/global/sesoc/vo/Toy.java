package global.sesoc.vo;

import java.util.List;

public class Toy {
	/**
	 * 고유번호 = SerialNumber
	 */
	private String serialNum;
	/**
	 * 이름 = Name
	 */
	private String name;
	/**
	 * 가격 = Price
	 */
	private int price;
	
	/**
	 * Default Constructor
	 */
	public Toy() {
		
	}
	/**
	 * Specific Constructor
	 */
	public Toy(List<Object> toyInfo) {
		this.serialNum = (String) toyInfo.get(0);
		this.name = (String) toyInfo.get(1);
		this.price = (Integer) toyInfo.get(2);
	}
	
	/**
	 *  toString method (override)
	 */
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("[고유번호 = ");
		buf.append(this.serialNum + ", ");
		buf.append("이름 = ");
		buf.append(this.name + ", ");
		buf.append("가격 = ");
		buf.append(Integer.toString(price));
		
		return buf.toString();
	}
	
	/**
	 * Getter and Setter
	 */
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
