package bankSystem;

public interface BankSecurity {
	final boolean lock = false;
	
	public abstract boolean checkPassword();
	
	public abstract void setLock(boolean lock);
	
	public abstract boolean isLock();
}

