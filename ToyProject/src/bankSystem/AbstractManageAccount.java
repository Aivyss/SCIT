package bankSystem;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class AbstractManageAccount {
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Account> manage = new ArrayList<Account>();
	//private Account[] account = new Account[10000]; (ArrayList를 모른다면 이것을 사용해도 됨)
	

	// Check duplication of account number
	protected abstract boolean checkDuplication(String accountNum); // true -> OK; false ->NO

	// Store account information method
	protected abstract void store(Account account);

	// Search Account Process
	protected abstract int search(String accountNum); // extract index
	
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