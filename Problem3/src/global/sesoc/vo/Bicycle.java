package global.sesoc.vo;

import java.util.List;

public class Bicycle extends Toy {
	/**
	 * 자전거 종류 = type
	 */
	private String type;
	
	/**
	 * default Constructor
	 */
	public Bicycle() {
		
	}
	/**
	 * Specific Constructor
	 */
	public Bicycle(List<Object> toyInfo) {
		super(toyInfo);
		this.type = (String) toyInfo.get(3);
	}
	
	/*
	 * toString method
	 */
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		String toy = super.toString();
		buf.append("[자전거]");
		buf.append(toy + ", ");
		buf.append("종류 = ");
		buf.append(type + "]");
		
		return buf.toString();
	}
	
	/**
	 * Getter and Setter
	 */
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}