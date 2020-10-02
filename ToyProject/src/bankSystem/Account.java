package bankSystem;

import java.util.Random;
import java.util.Scanner;

public class Account {
	private Scanner sc = new Scanner(System.in);
	private String bankName;
	private String[] accountNum = new String[3];
	private String kindOfAccount;
	private String password;
	private boolean lock;
	private double balance;
	
	public Account(ManageAccount manage) {
		// Define variables
		int selector;

		// input information part
		System.out.print("Input the name of account holder : ");
		this.bankName = sc.nextLine();
		
		System.out.print("Choose the kind of account : ");
		selector = sc.nextInt();
		kindOfAccount(selector);
		
		selector = sc.nextInt();
		System.out.print("Choose your location : ");
		location(selector);
		
		generateAccount(manage);
		
		sc.nextLine();
		System.out.print("Choose your deposit password");
		this.password = sc.nextLine();
	}
	
	private void kindOfAccount(int selector) {		
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
	
	private void location(int selector) {
		System.out.println("1: Seoul / 2: Gyeonggi / 3: Incheon / 3: ChungCheong / 4: Gangwon / 5: Jeonra / 6: Gyeongsang / 7: Jeju");
		switch(selector) {
		case 1 :
			this.accountNum[0] = "001";
			break;
		case 2 :
			this.accountNum[0] = "002";
			break;
		case 3 :
			this.accountNum[0] = "003";
			break;
		case 4 :
			this.accountNum[0] = "004";
			break;
		case 5 :
			this.accountNum[0] = "005";
			break;
		case 6 :
			this.accountNum[0] = "006";
			break;
		case 7 :
			this.accountNum[0] = "007";
			break;
		}
		
	}
	
	private void generateAccount(ManageAccount manage) {
		Random rd = new Random();
		String accountNumMiddle = "";
		for (int i=0; i<9; i++) {
			accountNumMiddle +=rd.nextInt(10);
		}
		
		if(manage.checkDuplication(accountNumMiddle)) {
			this.accountNum[1] = accountNumMiddle;
		} else {
			generateAccount(manage);
		}
	} // generateAccount method end
	
	// withdrawal method
	public void withdrawal() {
		// Define variables
		double withdrawMoney;
		int count = 0;
		
		// Check locking
		if (lock) {
			System.out.println("Your account is locked");
			return;
		}
		
		// Check password
		for (int i=0; i<3; i++) {
			System.out.print("Input your password");
			String password = sc.nextLine();
			if (password.equals(this.password)) {
				break;
			} else {
				count++;
				
				if (count == 3) {
					this.lock = true;
					return;
				}
			}
		}
		
		// Process
		System.out.print("How much do you want ? : ");
		withdrawMoney = sc.nextInt();
		if (withdrawMoney > this.balance) {
			System.out.println("Exceed limit, input again");
			withdrawal();
		} else {
			this.balance = this.balance-withdrawMoney;
		}
	}
	
	public double withdrawal(double money) {
		if (money > this.balance) {
			System.out.println("Exceed limit, input again");
			money = sc.nextInt();
			withdrawal(money);
		} else {
			this.balance = this.balance-money;
		}
		return money;
	}
	
	public void deposit() {
		System.out.print("put in your money : ");
		double depositMoney = sc.nextInt();
		this.balance += depositMoney;
	}
	
	public void deposit(double money) {
		this.balance += money;
	}
	
	// Getter
	public String[] getAccountNum() {
		return accountNum;
	}
}