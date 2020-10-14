package bankSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManageAccount extends AbstractManageAccount {
	private Scanner sc = new Scanner(System.in);
	private final String ACCOUNTNUMPATTERN = "^([0-9]{3})\\-([0-9]{9})\\-([0-9]{2})$";
	private Map<String, Account> manage = new HashMap<String, Account>();
	private final double FEERANGE1 = 300000;
	private final double FEERANGE2 = 1500000;
	private final double FEE1 = 400;
	private final double FEE2 = 1500;
	private final double FEE3 = 2000;
	

	// Check duplication of account number
	protected boolean checkDuplication(String accountNum) { // true -> OK; false ->NO
		boolean flag = true;
		
		if (manage.get(accountNum) == null) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	// Store account information method
	protected void store(Account account) {
		manage.put(account.getAccountNum(), account);
	}

	// Search Process
	protected boolean search(String accountNum) { // true -> detected, false -> nothing
		boolean flag = false;
		
		if (manage.get(accountNum) != null) {
			flag = true;
		} else {
			System.out.println("Do you want input account number again? (Y/N) : ");
			String str = sc.nextLine();
			if ("Y".equals(str)) {
				accountNum = sc.nextLine();
			} else {
				flag = false;
			}	
		}
		
		return flag;
	}
	// input account number method
	protected String inputNum() {
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
	protected void remit() {
		double transportedMoney;

		// Account checking 1
		String startAccount = inputNum();
		if ("".equals(startAccount)) {
			System.out.println("Turn off");
			return;
		}
		
		// search process 1
		if (!search(startAccount)) {
			System.out.println("Turn off");
			return;
		}

		// Account checking 2
		String endAccount = inputNum();
		if ("".equals(endAccount)) {
			System.out.println("Turn off");
			return;
		}
		
		// search process 2
		if (!search(endAccount)) {
			System.out.println("Turn off");
			return;
		}

		// Remit Process
		System.out.print("Hou much do you want to remit? : ");
		transportedMoney = sc.nextInt();
		double fee = 0;
		sc.nextLine();

		Account start = manage.get(startAccount);
		Account end = manage.get(endAccount);
		
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
			
			manage.replace(startAccount, start);
			manage.replace(endAccount, end);
		}
	}

	// deposit process
	protected void deposit() {
		// Input account number
		String accountNum = inputNum();
		if ("".equals(accountNum)) {
			return;
		}

		// search account
		if (!search(accountNum)) {
			System.out.println("Turn off");
			return;
		}
		
		// deposit process
		Account account = manage.get(accountNum);
		account.deposit();

		manage.replace(accountNum, account);
	}

	// withdraw process
	protected void withdrawal() {
		// Input account number
		String accountNum = inputNum();
		if ("".equals(accountNum)) {
			return;
		}

		// search account
		if (!search(accountNum)) {
			System.out.println("Turn off");
			return;
		}
		
		Account account = manage.get(accountNum);

		// check the password and lock
		if (account.isLock() || !checkPassword(account)) {
			System.out.println("Your account are locked");
			return;
		}

		account.withdrawal();

		manage.replace(accountNum, account);
	}

	protected void checkBalance() {
		// Input account number
		String accountNum = inputNum();
		if (accountNum.equals("")) {
			return;
		}

		// search account
		if (!search(accountNum)) {
			System.out.println("Turn off");
			return;
		}
		Account account = manage.get(accountNum);

		// check the password and lock
		if (account.isLock() || !checkPassword(account)) {
			System.out.println("Your account are locked");
			return;
		}

		account.checkBalanace();
	}

	protected boolean checkPassword(Account account) {
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