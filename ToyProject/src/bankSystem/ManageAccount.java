package bankSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageAccount {
	private Scanner sc = new Scanner(System.in);
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
		
		for (int i=0; i<manage.size(); i++) {
			if (accountNum.equals(((Account) manage.get(i)).getAccountNum())) {
				result = (Account) manage.get(i);
			} else {
				if (i == manage.size()-1) {
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
		System.out.print("input your account number : ");
		String startAccount = sc.nextLine();
		int startIndex=0;
		for (int i = 0; i < manage.size(); i++) {
			Account temp = (Account) manage.get(i);
			if (startAccount.equals(temp.getAccountNum())) {
				startIndex=i;
				break;
			} else {
				remit();
			}
		}
		
		// Account checking 2
		System.out.print("input target account number : ");
		String endAccount = sc.nextLine();
		int endIndex=0;
		for (int i = 0; i < manage.size(); i++) {
			Account temp = (Account) manage.get(i);
			if (endAccount.equals(temp.getAccountNum())) {
				endIndex=i;
				break;
			} else {
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
	
	public void deposit() {
		int detected = 0;
		Account account = null;
		
		System.out.print("Input your account number : ");
		String accountNum = sc.nextLine();
		
		for (int i=0; i<manage.size(); i++) {
			if(((Account) manage.get(i)).getAccountNum().equals(accountNum)) {
				detected = i;
				account = (Account) manage.get(i);
				break;
			} 
			
			if (i == manage.size()-1) {
				System.out.print("No result.");
				deposit();
			}
		}
		
		account.deposit();
		
		manage.set(detected, account);
	}
	
	public void withdrawal() {
		int detected = 0;
		Account account = null;
		
		System.out.print("Input your account number : ");
		String accountNum = sc.nextLine();
		
		for (int i=0; i<manage.size(); i++) {
			if(((Account) manage.get(i)).getAccountNum().equals(accountNum)) {
				detected = i;
				account = (Account) manage.get(i);
				break;
			} 
			
			if (i == manage.size()-1) {
				System.out.print("No result.");
				withdrawal();
			}
		}
		
		account.withdrawal();
		
		manage.set(detected, account);
	}
	
	public void checkBalance() {
		int detected = 0;
		Account account = null;
		
		System.out.print("Input your account number : ");
		String accountNum = sc.nextLine();
		
		for (int i=0; i<manage.size(); i++) {
			if(((Account) manage.get(i)).getAccountNum().equals(accountNum)) {
				detected = i;
				account = (Account) manage.get(i);
				break;
			} 
			
			if (i == manage.size()-1) {
				System.out.print("No result.");
				checkBalance();
			}
		}
		
		account.checkBalanace();
	}
}
