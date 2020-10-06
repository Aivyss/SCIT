package bankSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageAccount {
	private Scanner sc = new Scanner(System.in);
	private final String ACCOUNTNUMPATTERN = "^([0-9]{3})\\-([0-9]{9})\\-([0-9]{2})$";
	private ArrayList<Object> manage = new ArrayList<Object>();
	private final double FEERANGE1 = 300000;
	private final double FEERANGE2 = 1500000;
	private final double FEE1 = 400;
	private final double FEE2 = 1500;
	private final double FEE3 = 2000;
	

	// Check duplication of account number
	public boolean checkDuplication(String accountNum) { // true -> OK; false ->NO
		boolean flag = true;

		if (manage.size() == 0) {
			flag = true;
		} else {
			for (int i = 0; i < manage.size(); i++) {
				Account temp = (Account) manage.get(i);
				if (temp.getAccountNum().equals(accountNum)) {
					flag = false;
				}
			}
		}
		return flag;
	}

	// Store account information method
	public void store(Account account) {
		manage.add(account);
	}

	// Find Process
	public int search(String accountNum) { // extract index
		int detected = -2;
		
		for (int i = 0; i < manage.size(); i++) {
			if (((Account) manage.get(i)).getAccountNum().equals(accountNum)) {
				detected = i;
				break;
			}

			if (i == manage.size() - 1) {
				System.out.print("No result.");
				System.out.print("Do You want to stop? (Y/N): ");
				String selector = sc.nextLine();
				if (selector.equals("Y")) {
					detected = -1; // Do not Process
				} else {
					detected = -2; // Do again
				}
			}
		}
		
		return detected;
	}
	// input account number method
	public String inputNum() {
		String accountNum = "";
		while (true) {
			System.out.print("input your account number : ");
			accountNum = sc.nextLine();

			if (!accountNum.matches(ACCOUNTNUMPATTERN)) {
				System.out.println("Input exactly");
				System.out.print("Do You want to stop? (1/0): ");
				int selector = sc.nextInt();
				sc.nextLine();
				if (selector == 1) {
					accountNum = "";
					break;
				}
			} else {
				break;
			}
		}
		
		return accountNum;
	}

	// Remit method
	public void remit() {
		double transportedMoney;

		// Account checking 1
		String startAccount = inputNum();
		if (startAccount.equals("")) {
			return;
		}
		
		// search process 1
		int startIndex = 0;
		if (search(startAccount) == -1) {
			return;
		} else if (search(startAccount) == -2) {
			remit();
		} else {
			startIndex = search(startAccount);
		}

		// Account checking 2
		String endAccount = inputNum();
		if (startAccount.equals("")) {
			return;
		}
		
		// search process 2
		int endIndex = 0;
		if (search(endAccount) == -1) {
			return;
		} else if (search(endAccount) == -2) {
			remit();
		} else {
			endIndex = search(endAccount);
		}

		// Remit Process
		System.out.print("Hou much do you want to remit? : ");
		transportedMoney = sc.nextInt();
		double fee = 0;
		sc.nextLine();

		Account start = (Account) manage.get(startIndex);
		Account end = (Account) manage.get(endIndex);
		
		// Check fee
		if(!start.getBankName().equals(end.getBankName())) {
			if (transportedMoney > FEERANGE2) {
				fee = FEE3;
			} else if (transportedMoney > FEERANGE1) {
				fee = FEE2;
			} else {
				fee = FEE1;
			}
		} else {
			fee = 0;
		}
		
		transportedMoney = start.withdrawal(transportedMoney+fee);
		if (transportedMoney == 0) {
			System.out.println("Not processed");
			remit();
		} else {
			transportedMoney-=fee;
			end.deposit(transportedMoney);

			manage.set(startIndex, start);
			manage.set(endIndex, end);
		}
	}

	// deposit process
	public void deposit() {
		int detected = 0;

		// Input account number
		String accountNum = inputNum();
		if (accountNum.equals("")) {
			return;
		}

		// search account
		if (search(accountNum) == -1) {
			return;
		} else if (search(accountNum) == -2) {
			deposit();
		} else {
			detected = search(accountNum);
		}
		
		Account account = (Account) manage.get(detected);
		account.deposit();

		manage.set(detected, account);
	}

	// withdraw process
	public void withdrawal() {
		int detected = 0;

		// Input account number
		String accountNum = inputNum();
		if (accountNum.equals("")) {
			return;
		}

		// search account
		if (search(accountNum) == -1) {
			return;
		} else if (search(accountNum) == -2) {
			withdrawal();
		} else {
			detected = search(accountNum);
		}	
		Account account = (Account) manage.get(detected);

		// check the password and lock
		if (account.isLock() || !checkPassword(account)) {
			System.out.println("Your account are locked");
			manage.set(detected, account);
			return;
		}

		account.withdrawal();

		manage.set(detected, account);
	}

	public void checkBalance() {
		int detected = 0;

		// Input account number
		String accountNum = inputNum();
		if (accountNum.equals("")) {
			return;
		}

		// search account
		if (search(accountNum) == -1) {
			return;
		} else if (search(accountNum) == -2) {
			checkBalance();
		} else {
			detected = search(accountNum);
		}	
		Account account = (Account) manage.get(detected);

		// check the password and lock
		if (account.isLock() || !checkPassword(account)) {
			System.out.println("Your account are locked");
			manage.set(detected, account);
			return;
		}

		account.checkBalanace();
	}

	public boolean checkPassword(Account account) {
		boolean flag = false;
		int count = 0;

		// Check password
		for (int i = 0; i < 3; i++) {
			System.out.print("Input your password : ");
			String password = sc.nextLine();

			if (password.equals(account.getPassword())) {
				flag = true;
				break;
			} else {
				count++;

				if (count == 3) {
					account.setLock(true);
					flag = false;
				}
			}
		}

		return flag;
	}
}
