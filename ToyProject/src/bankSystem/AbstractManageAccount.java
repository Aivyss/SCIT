package bankSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class AbstractManageAccount {
	private Scanner sc = new Scanner(System.in);
	private Map<String, Account> manage = new HashMap<String, Account>();
	

	// Check duplication of account number
	protected abstract boolean checkDuplication(String accountNum); // true -> OK; false ->NO

	// Store account information method
	protected abstract void store(Account account);

	// Search Account Process
	protected abstract boolean search(String accountNum); // extract index
	
	// input account number method
	protected abstract String inputNum();

	// Remit method
	protected abstract void remit();

	// deposit process
	protected abstract void deposit();

	// withdraw process
	protected abstract void withdrawal();
	
	// check balance process
	protected abstract void checkBalance();
	
	// check password process
	protected abstract boolean checkPassword(Account account);
}