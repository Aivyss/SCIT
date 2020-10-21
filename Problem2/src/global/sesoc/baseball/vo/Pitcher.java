package global.sesoc.baseball.vo;

/**
 * 투수 정보 VO
 */
public class Pitcher extends Player  {
	/**
	 * 평균 자책
	 */
	private double era;	
	/**
	 * 이닝
	 */
	private int inning;
	/**
	 * 승
	 */
	private int wins;
	/**
	 * 패
	 */
	private int losses;	
	/**
	 * 세이브
	 */
	private int save;
	/**
	 * 홀드
	 */
	private int hold;
	
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
		buf.append(", 이닝: ");
		buf.append(this.getInning());
		buf.append(", 승: ");
		buf.append(this.getWins());
		buf.append(", 패: ");
		buf.append(this.getLosses());
		buf.append(", 세이브: ");
		buf.append(this.getSave());
		buf.append(", 홀드: ");
		buf.append(this.getHold());
		
		return buf.toString();
	}
	
	/**
	 * Setter and Getter
	 * @param era
	 */
	public void setEra(double era) {
		this.era = era;
	}
	public void setInning(int inning) {
		this.inning = inning;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public void setSave(int save) {
		this.save = save;
	}
	public void setHold(int hold) {
		this.hold = hold;
	}
	public double getEra() {
		return era;
	}
	public int getInning() {
		return inning;
	}
	public int getWins() {
		return wins;
	}
	public int getLosses() {
		return losses;
	}
	public int getSave() {
		return save;
	}
	public int getHold() {
		return hold;
	}
	
	
	
}
