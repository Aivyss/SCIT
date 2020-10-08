package bankSystem;

import java.util.Random;
import java.util.Scanner;

public class Account extends AbstractAccount {
	private Scanner sc = new Scanner(System.in);
	private String accountHolderName;
	private String bankName;
	private String[] accountNum = new String[3];
	private String kindOfAccount;
	private String password;
	private boolean lock;
	private double balance;

	public Account(ManageAccount manage, String accountHolderName, String bankName, int selectAccount, int selectLocation, String password) {
		// input information part
		this.accountHolderName = accountHolderName;
		this.bankName = bankName;
		this.password = password;
		this.lock = false;
		
		kindOfAccount(selectAccount);		
		location(selectLocation);
		generateAccount(manage);
		
		System.out.println(this.accountNum[0] + "-" + this.accountNum[1] + "-" + this.accountNum[2]);	
	}

	protected void kindOfAccount(int selector) {
		if (selector == 1) {
			this.kindOfAccount = "Checking account";
			this.accountNum[2] = "01";
		} else if (selector == 2) {
			this.kindOfAccount = "Annual time deposit";
			this.accountNum[2] = "02";
		} else {
			System.out.print("Choose again : ");
			selector = sc.nextInt();
			kindOfAccount(selector);
		}
	}

	protected void location(int selector) {
		switch (selector) {
		case 1:
			this.accountNum[0] = "001";
			break;
		case 2:
			this.accountNum[0] = "002";
			break;
		case 3:
			this.accountNum[0] = "003";
			break;
		case 4:
			this.accountNum[0] = "004";
			break;
		case 5:
			this.accountNum[0] = "005";
			break;
		case 6:
			this.accountNum[0] = "006";
			break;
		case 7:
			this.accountNum[0] = "007";
			break;
		}
	}

	protected void generateAccount(ManageAccount manage) {
		Random rd = new Random();
		String accountNumMiddle = "";
		
		for (int i = 0; i < 9; i++) {
			accountNumMiddle += rd.nextInt(10);
		}

		String checkNum = accountNum[0] + "-" + accountNumMiddle + "-" + accountNum[2];

		if (manage.checkDuplication(checkNum)) {
			this.accountNum[1] = accountNumMiddle;
		} else {
			generateAccount(manage);
		}
	} // generateAccount method end

	// withdrawal method
	public void withdrawal() {
		// Define variables
		double withdrawMoney;

		// Process
		System.out.print("How much do you want ? : ");
		withdrawMoney = sc.nextInt();
		if (withdrawMoney > this.balance) {
			System.out.println("Exceed limit, input again");
			withdrawal();
		} else {
			this.balance = this.balance - withdrawMoney;
		}
	}

	public double withdrawal(double money) {
		if (money > this.balance) {
			System.out.println("Exceed limit, input again");
			money = sc.nextInt();
			withdrawal(money);
		} else {
			this.balance = this.balance - money;
		}
		return money;
	}

	protected void deposit() {
		System.out.print("put in your money : ");
		double depositMoney = sc.nextInt();
		this.balance += depositMoney;
	}

	protected void deposit(double money) {
		this.balance += money;
	}
	
	// Check Balanace method
	protected void checkBalanace() {
		System.out.println("Your Balance : " + this.balance);
	}
	
	// Password check method
	protected boolean checkPassword() { // true: proceed, false: locking
		boolean flag = false;
		int count = 0;
		
		// Check password
		for (int i = 0; i < 3; i++) {
			System.out.print("Input your password : ");
			String password = sc.nextLine();

			if (password.equals(this.password)) {
				flag = true;
				break;
			} else {
				count++;

				if (count == 3) {
					this.lock = true;
					flag = false;
				}
			}
		}
		
		return flag;
	}

	// Getter & Setter
	protected String getAccountNum() {
		String accountNum = this.accountNum[0] + "-" + this.accountNum[1] + "-" + this.accountNum[2];

		return accountNum;
	}

	protected String getPassword() {
		return password;
	}

	protected void setLock(boolean lock) {
		this.lock = lock;
	}

	protected boolean isLock() {
		return lock;
	}

	protected String getBankName() {
		return bankName;
	}
}
