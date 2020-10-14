package bankSystem;

import java.util.Scanner;

public class BankMain {

	public static void main(String[] args) {
		// Define variables
		Scanner sc = new Scanner(System.in);
		ManageAccount manage = new ManageAccount();
		boolean flag = true;

		while (flag) {
			// Menu UI
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
			sc.nextLine();
			
			// Create new account
			if (selector == 1) {
				// input information part
				System.out.print("Input the name of account holder : ");
				String accountHolderName = sc.nextLine();

				System.out.print("Input the name of bank : ");
				String bankName = sc.nextLine();

				System.out.print("Choose the kind of account : ");
				int selectAccount = sc.nextInt();
				
				System.out.println(
						"1: Seoul / 2: Gyeonggi / 3: Incheon / 3: ChungCheong / 4: Gangwon / 5: Jeonra / 6: Gyeongsang / 7: Jeju");
				System.out.print("Choose your location : ");
				int selectLocation = sc.nextInt();

				sc.nextLine();
				System.out.print("Choose your deposit password :");
				String password = sc.nextLine();
				
				Account acc = new Account(manage, accountHolderName, bankName, selectAccount, selectLocation, password);
				
				manage.store(acc);
			} else if (selector == 2) { // Deposit
				manage.deposit();
			} else if (selector == 3) { // Withdraw
				manage.withdrawal();
			} else if (selector == 4) { // Remit
				manage.remit();
			} else if (selector == 5) { // Check Balance
				manage.checkBalance();
			} else if (selector == 6) { // End program
				flag = false;
			}
		}
		
		sc.close();
	}
}
