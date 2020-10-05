package bankSystem;

public class BankMain {

	public static void main(String[] args) {
		ManageAccount manage = new ManageAccount();
		BankUI ui = new BankUI();

		boolean flag = true;

		while (flag) {
			int selector = ui.menuUI();

			if (selector == 1) {
				Account acc = new Account(manage);
				manage.store(acc);
			} else if (selector == 2) {
				manage.deposit();
			} else if (selector == 3) {
				manage.withdrawal();
			} else if (selector == 4) {
				manage.remit();
			} else if (selector == 5) {
				manage.checkBalance();
			} else if (selector == 6) {
				flag = false;
			}
		}
	}
}
