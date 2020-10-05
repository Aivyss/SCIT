package bankSystem;

import java.util.Scanner;

public class BankUI {
	private Scanner sc = new Scanner(System.in);
	public int menuUI() {
		System.out.println("==================================");
		System.out.println("1. Make a new bank account");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Remit");
		System.out.println("5. Look up balance");
		System.out.println("6. End");
		System.out.println("==================================");
		System.out.print("Select >");
		int selector = sc.nextInt();
		
		return selector;
	}
	
	public void depositUI(ManageAccount manage) {
		System.out.print("Input your account number: ");
		String accountNum = sc.nextLine();
		manage.deposit(accountNum);
	}
	
	public void withdrawUI(ManageAccount manage) {
		System.out.print("Input your account number: ");
		String accountNum = sc.nextLine();
		manage.withdrawal(accountNum);
	}
	
	public void checkBalanaceUI(ManageAccount manage) {
		System.out.print("Input your account number: ");
		String accountNum = sc.nextLine();
		manage.checkBalance(accountNum);
	}
}
