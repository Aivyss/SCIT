package global.sesoc.vo;

import java.util.List;

public class Drone extends Toy {
	/**
	 * 날개 수 = Wing Count
	 */
	private int wingCount;
	
	/**
	 * Default constructor
	 */
	public Drone() {
		
	}
	/**
	 * Specific constructor
	 */
	public Drone(List<Object> toyInfo) {
		super(toyInfo);
		this.wingCount = (Integer) toyInfo.get(3);
	}
	
	/*
	 * toString method
	 */
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		String toy = super.toString();
		buf.append("[드론]");
		buf.append(toy + ", ");
		buf.append("날개 수 = ");
		buf.append(Integer.toString(this.wingCount) + "]");
		
		return buf.toString();
	}
	
	/**
	 * Getter and Setter
	 */
	public int getWingCount() {
		return wingCount;
	}
	public void setWingCount(int wingCount) {
		this.wingCount = wingCount;
	}
}