package bankSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageAccount {
	private Scanner sc = new Scanner(System.in);
	private final String ACCOUNTNUMPATTERN = "^([0-9]{3})\\-([0-9]{9})\\-([0-9]{3})$";
	private ArrayList<Object> manage = new ArrayList<Object>();

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
	public Account find(String accountNum) {
		Account result = null;

		for (int i = 0; i < manage.size(); i++) {
			if (accountNum.equals(((Account) manage.get(i)).getAccountNum())) {
				result = (Account) manage.get(i);
			} else {
				if (i == manage.size() - 1) {
					System.out.println("No result input again");
					accountNum = sc.nextLine();
					find(accountNum);
				}
			}
		}
		return result;
	}

	// Remit method
	public void remit() {
		double transportedMoney;

		// Account checking 1
		String startAccount = "";
		while (true) {
			System.out.print("input your account number : ");
			startAccount = sc.nextLine();

			if (!startAccount.matches(ACCOUNTNUMPATTERN)) {
				System.out.println("Input exactly");
				System.out.print("Do You want to stop? (1/0): ");
				int selector = sc.nextInt();
				if (selector == 1) {
					return;
				}
			} else {
				break;
			}
		}
		int startIndex = 0;
		for (int i = 0; i < manage.size(); i++) {
			Account temp = (Account) manage.get(i);
			if (startAccount.equals(temp.getAccountNum())) {
				startIndex = i;
				break;
			} else {
				System.out.print("Do You want to stop? (1/0): ");
				int selector = sc.nextInt();
				if (selector == 1) {
					return;
				}
				remit();
			}
		}

		// Account checking 2
		String endAccount = "";
		while (true) {
			System.out.print("input target account number : ");
			endAccount = sc.nextLine();

			if (!endAccount.matches(ACCOUNTNUMPATTERN)) {
				System.out.println("Input exactly");
				System.out.print("Do You want to stop? (1/0): ");
				int selector = sc.nextInt();
				if (selector == 1) {
					return;
				}
			} else {
				break;
			}
		}

		int endIndex = 0;
		for (int i = 0; i < manage.size(); i++) {
			Account temp = (Account) manage.get(i);
			if (endAccount.equals(temp.getAccountNum())) {
				endIndex = i;
				break;
			} else {
				System.out.print("Do You want to stop? (1/0): ");
				int selector = sc.nextInt();
				if (selector == 1) {
					return;
				}
				remit();
			}
		}

		// Remit Process
		System.out.print("Hou much do you want to remit? : ");
		transportedMoney = sc.nextInt();

		Account start = (Account) manage.get(startIndex);
		Account end = (Account) manage.get(endIndex);

		transportedMoney = start.withdrawal(transportedMoney);
		if (transportedMoney == 0) {
			System.out.println("Not processed");
			remit();
		} else {
			end.deposit(transportedMoney);

			manage.set(startIndex, start);
			manage.set(endIndex, end);
		}
	}

	// deposit process
	public void deposit() {
		int detected = 0;
		Account account = null;

		// Input account number
		String accountNum = "";
		while (true) {
			System.out.print("input target account number : ");
			accountNum = sc.nextLine();

			if (!accountNum.matches(ACCOUNTNUMPATTERN)) {
				System.out.println("Input exactly");
				System.out.print("Do You want to stop? (1/0): ");
				int selector = sc.nextInt();
				if (selector == 1) {
					return;
				}
			} else {
				break;
			}
		}

		// Search account
		for (int i = 0; i < manage.size(); i++) {
			if (((Account) manage.get(i)).getAccountNum().equals(accountNum)) {
				detected = i;
				account = (Account) manage.get(i);
				break;
			}

			if (i == manage.size() - 1) {
				System.out.print("No result.");
				deposit();
			}
		}

		account.deposit();

		manage.set(detected, account);
	}

	// witdraw process
	public void withdrawal() {
		int detected = 0;
		Account account = null;

		// input account number
		System.out.print("Input your account number : ");
		String accountNum = sc.nextLine();

		// check pattern
		if (!accountNum.matches(ACCOUNTNUMPATTERN)) {
			System.out.println("Input exactly");
			System.out.print("Do You want to stop? (1/0): ");
			int selector = sc.nextInt();
			if (selector == 1) {
				return;
			} else {
				withdrawal();
			}
		}

		for (int i = 0; i < manage.size(); i++) {
			if (((Account) manage.get(i)).getAccountNum().equals(accountNum)) {
				detected = i;
				account = (Account) manage.get(i);
				break;
			}

			if (i == manage.size() - 1) {
				System.out.print("No result.");
				System.out.print("Do You want to stop? (1/0): ");
				int selector = sc.nextInt();
				if (selector == 1) {
					return;
				} else {
					withdrawal();
				}
			}
		}

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
		Account account = null;

		// Input account number
		String accountNum = "";
		while (true) {
			System.out.print("input target account number : ");
			accountNum = sc.nextLine();

			if (!accountNum.matches(ACCOUNTNUMPATTERN)) {
				System.out.println("Input exactly");
				System.out.print("Do You want to stop? (1/0): ");
				int selector = sc.nextInt();
				if (selector == 1) {
					return;
				}
			} else {
				break;
			}
		}

		for (int i = 0; i < manage.size(); i++) {
			if (((Account) manage.get(i)).getAccountNum().equals(accountNum)) {
				detected = i;
				account = (Account) manage.get(i);
				break;
			}

			if (i == manage.size() - 1) {
				System.out.print("No result.");
				checkBalance();
			}
		}

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
