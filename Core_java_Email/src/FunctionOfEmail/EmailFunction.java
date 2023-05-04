package FunctionOfEmail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pojo.Account;
import pojo.InBox;
import pojo.OutBox;

public class EmailFunction {
	private List<Account> accounts = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public boolean accountExist(String email) {
		if (accounts.isEmpty())
			return false;
		for (Account account : accounts)
			if (account.getEmail().equals(email))
				return true;
		return false;
	}

	public boolean creatNewAccount(String email, String password) {
		if (!accountExist(email)) {
			accounts.add(new Account(email, password));
			System.out.println("***email Created go to login to access your account***");
			return true;
		} else {
			System.out.println("***email already exists use another email address***");
			return false;
		}
	}

	public void allEmailInSystem() {
		System.out.println("***mail_id in system***");
		for (Account account : accounts)
			System.out.println(account);
	}

	// success
	public boolean passworsCheck(String email, String passeord) {
		for (Account account : accounts) {
			if (account.getEmail().equals(email) && account.getPassword().equals(passeord)) {
				System.out.println("***log-in success***");
				return true;
			}
		}
		System.out.println("***password wrong***");
		return false;

	}

	public void sendNewMail(String Smail) {
		while (true) {
			System.out.println("enter to mail id");
			String rMail = sc.next();
			int temp = 2;
			if (accountExist(rMail)) {
				System.out.println("enter to the message to send");
				sc.nextLine();
				String message = sc.nextLine();
				addTOInAndOutbox(Smail, rMail, message);

			} else {
				System.out.println("mail_id not found");
				System.out.println("press 1 to eanter new mail_id");
				System.out.println("press 2 to to see log-in menu");
				temp = sc.nextInt();
			}
			if (temp == 2)
				break;
		}

	}

	public void addTOInAndOutbox(String sMail, String rMail, String message) {
		for (Account account : accounts) {
			if (account.getEmail().equals(sMail)) {
				account.setOutBox(new OutBox(rMail, message));
			}
			if (account.getEmail().equals(rMail)) {
				account.setInBox(new InBox(sMail, message));
			}
		}

	}

	public void showInbox(String email) {
		Account account = findAndSendAccount(email);
		if (!account.getInBox().isEmpty()) {
			System.out.println("***mail in inbox of"+account.getEmail() +"***");
			for (InBox inBox : account.getInBox())
				System.out.println(inBox);
		} else {
			System.out.println("***inbox is empty***");
		}
	}

	public void showOutbox(String email) {
		Account account = findAndSendAccount(email);
		if (!account.getOutBox().isEmpty()) {
			System.out.println("***mail in onbox of"+account.getEmail() +"***");
			for (OutBox outBox : account.getOutBox())
				System.out.println(outBox);
		} else {
			System.out.println("***outbox is empty***");
		}
	}

	public Account findAndSendAccount(String eMail) {
		for (Account account : accounts) {
			if (account.getEmail().equals(eMail)) {
				return account;
			}
		}
		return new Account(eMail, eMail);

	}
}
