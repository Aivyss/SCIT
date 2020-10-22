package global.sesoc.baseball.vo;

import java.util.List;

/**
 * 선수 정보 VO 클래스들의 상위 클래스
 */
public class Player {
	/**
	 * 선수 고유 번호
	 */
	private String id;
	/**
	 * 선수 이름
	 */
	private String name;
	/**
	 * 소속 팀 정보
	 */
	private String team;
	/**
	 * 연봉
	 */
	private int salary;
	/**
	 * WAR
	 */
	private double war;
	
	/**
	 * default constructor
	 */
	public Player() {
		
	}
	/**
	 * specific constructor
	 */
	public Player(List<Object> playerInfo) {
		// id, 선수이름, 소속팀, 연봉, War
		this.id = (String) playerInfo.get(0);
		this.name = (String) playerInfo.get(1);
		this.team = (String) playerInfo.get(2);
		this.salary = (Integer) playerInfo.get(3);
		this.war = (Double) playerInfo.get(4);
	}
	
	/*
	 * toString Override
	 */
	@Override
	public String toString() {
		String output = "";
		StringBuffer buf = new StringBuffer();
		buf.append("ID:");
		buf.append(this.getId());
		buf.append(", 이름:");
		buf.append(this.getName());
		buf.append(", 소속팀:");
		buf.append(this.getTeam());
		buf.append(", 연봉:");
		buf.append(this.getSalary());
		buf.append(", WAR:");
		buf.append(this.getWar());
		return output;
	}
	/**
	 * Getter and Setter
	 */
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setWar(double war) {
		this.war = war;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTeam() {
		return team;
	}

	public int getSalary() {
		return salary;
	}

	public double getWar() {
		return war;
	}
	
}
