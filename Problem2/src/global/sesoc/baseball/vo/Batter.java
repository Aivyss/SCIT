package global.sesoc.baseball.vo;

import java.util.List;

/**
 * 타자 정보 VO
 */
public class Batter extends Player {
	/**
	 * 타율
	 */
	private double average;
	/**
	 * 타수
	 */
	private int atbat;
	/**
	 * 타점
	 */
	private int rbi;
	/**
	 * 득점
	 */
	private int score;
	/**
	 * Default constructor
	 */
	public Batter() {
		
	}
	
	/**
	 * Specific constructor
	 */
	public Batter(List<Object> playerInfo) {
		super(playerInfo);
		this.average = (Double) playerInfo.get(5);
		this.atbat = (Integer) playerInfo.get(6);
		this.rbi = (Integer) playerInfo.get(7);
		this.score = (Integer) playerInfo.get(8);
	}
	
	/**
	 * 선수의 정보를 출력하는 메소드. toStirng의 오버라이딩
	 */
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("ID: ");
		buf.append(this.getId());
		buf.append(", 이름: ");
		buf.append(this.getName());
		buf.append(", 소속팀: ");
		buf.append(this.getTeam());
		buf.append(", 연봉: ");
		buf.append(this.getSalary());
		buf.append(", WAR: ");
		buf.append(this.getWar());
		buf.append(", 타율: ");
		buf.append(this.getAverage());
		buf.append(", 타수: ");
		buf.append(this.getAtbat());
		buf.append(", 타점: ");
		buf.append(this.getRbi());
		buf.append(", 득점: ");
		buf.append(this.getScore());
		
		return buf.toString();
	}
	
	/**
	 * Getter and Setter
	 * @return
	 */
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public int getAtbat() {
		return atbat;
	}
	public void setAtbat(int atbat) {
		this.atbat = atbat;
	}
	public int getRbi() {
		return rbi;
	}
	public void setRbi(int rbi) {
		this.rbi = rbi;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
