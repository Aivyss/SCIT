package global.sesoc.vo;

import java.util.List;

public class GameConsole extends Toy {
	/**
	 * 휴대용 = isPortable (Y/N)
	 */
	private boolean isPortable;
	
	/**
	 * default Constructor
	 */
	public GameConsole() {
		
	}
	
	/**
	 * Specific Constructor
	 */
	public GameConsole(List<Object> toyInfo) {
		super(toyInfo);
		this.isPortable = (Boolean) toyInfo.get(3);
		
	}
	/**
	 * toString() method
	 */
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		String toy = super.toString();
		buf.append("[게임콘솔]");
		buf.append(toy + ", ");
		buf.append("휴대용 = ");
		if (this.isPortable) {
			buf.append("Y]");
		} else {
			buf.append("N]");
		}
		
		return buf.toString();
	}
	/**
	 * Getter and Setter
	 */
	public boolean isPortable() {
		return isPortable;
	}

	public void setPortable(boolean isPortable) {
		this.isPortable = isPortable;
	}
	
	
}