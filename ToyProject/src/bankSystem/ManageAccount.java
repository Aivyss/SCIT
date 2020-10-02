package bankSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageAccount {
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Object> manage = new ArrayList<Object>();

	public boolean checkDuplication(String accountNumMiddle) {
		boolean flag = false;
		if (manage.size() == 0) {
			flag = true;
		} else {
			for (int i = 0; i < manage.size(); i++) {
				Account temp = (Account) manage.get(i);
				if (temp.getAccountNum()[1].equals(accountNumMiddle)) {
					flag = false;
				}
			}
		}
		return flag;
	}

	public void remit() {
		double transportedMoney;
		
		// Account checking 1
		System.out.print("input your account number : ");
		String startAccount = sc.nextLine();
		int startIndex=0;
		String[] startAccountSplit = startAccount.split("-");
		for (int i = 0; i < manage.size(); i++) {
			Account temp = (Account) manage.get(i);
			if (startAccountSplit[0].equals(temp.getAccountNum()[0])
					&& startAccountSplit[1].equals(temp.getAccountNum()[1])
					&& startAccountSplit[2].equals(temp.getAccountNum()[2])) {
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
		String[] endAccountSplit = endAccount.split("-");
		for (int i = 0; i < manage.size(); i++) {
			Account temp = (Account) manage.get(i);
			if (endAccountSplit[0].equals(temp.getAccountNum()[0])
					&& endAccountSplit[1].equals(temp.getAccountNum()[1])
					&& endAccountSplit[2].equals(temp.getAccountNum()[2])) {
				startIndex=i;
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
		end.deposit(transportedMoney);
		
		manage.set(startIndex, start);
		manage.set(endIndex, end);
	} 
}
