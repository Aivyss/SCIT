package bankSystem;

import java.util.Random;
import java.util.Scanner;

public abstract class AbstractAccount {
	private Scanner sc = new Scanner(System.in);
	private String accountHolderName;
	private String bankName;
	private String[] accountNum = new String[3];
	private String kindOfAccount;
	private String password;
	private boolean lock;
	private double balance;

	protected abstract void kindOfAccount(int selector);

	protected abstract void location(int selector);

	protected abstract void generateAccount(ManageAccount manage);

	protected abstract void withdrawal();

	protected abstract void deposit();
	
	protected abstract void checkBalanace();
	
	protected abstract boolean checkPassword();
		
	protected abstract String getAccountNum();

	protected abstract String getPassword();

	protected abstract void setLock(boolean lock);

	protected abstract boolean isLock();
	
	protected abstract String getBankName();
	
}
