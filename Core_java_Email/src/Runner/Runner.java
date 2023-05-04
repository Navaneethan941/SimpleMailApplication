package Runner;

import java.util.Scanner;

import FunctionOfEmail.EmailFunction;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub choose option

		Scanner sc = new Scanner(System.in);
		EmailFunction function = new EmailFunction();

		while (true) {
			System.out.println("are you welling to get into system (y/n) ");
			char entry = sc.next().charAt(0);
			if (entry == 'y' || entry == 'Y') {
				while (true) {
					System.out.println("press 1 to log-in");
					System.out.println("press 2 to sin-in");
					System.out.println("press 3 to exit");
					System.out.println("press 4 to see all exist mail_id");
					int entry1 = sc.nextInt();
					if (entry1 == 1) {
						while (true) {
							System.out.println("***you are in log-in***");
							System.out.println("enter the mail_id");
							String mail_id = sc.next();
							int temp1 = 2;
							if (function.accountExist(mail_id)) {
								while (true) {
									System.out.println("enter the password");
									String password = sc.next();
									int temp2 = 2;
									if (function.passworsCheck(mail_id, password)) {
										int temp3 = 5;
										while (true) {
											System.out.println("press 1 to send new mail");
											System.out.println("press 2 to see inbox");
											System.out.println("press 3 to see outbox");
											System.out.println("press 4 to see inbox/outbox");
											System.out.println("press 5 exit");
											temp3 = sc.nextInt();
											if (temp3 == 5) {
												break;
											}
											if (temp3 == 1) {
												function.sendNewMail(mail_id);
											}
											if (temp3 == 2) {
												function.showInbox(mail_id);
											}
											if (temp3 == 3) {
												function.showOutbox(mail_id);
											}
											if (temp3 == 4) {
												function.showInbox(mail_id);
												function.showOutbox(mail_id);
											}
										}
									} else {
										System.out.println("press 1 to retry");
										System.out.println("press 2 to go main manu");
										temp2 = sc.nextInt();
									}
									if (temp2 == 2)
										break;
								}

							} else {
								System.out.println("mail_id not found");
								System.out.println("press 1 to retry");
								System.out.println("press 2 to go main manu");
								temp1 = sc.nextInt();
							}
							if (temp1 == 2)
								break;
							// break;
						}
					}
					if (entry1 == 2) {
						while (true) {
							System.out.println("***you are in sin-in***");
							System.out.println("enter the mail_id");
							String mail_id = sc.next();
							System.out.println("enter the password");
							String password = sc.next();
							int temp = 2;
							if (!function.creatNewAccount(mail_id, password)) {
								System.out.println("press 1 to retry");
								System.out.println("press 2 to go main manu");
								temp = sc.nextInt();
							}
							if (temp == 2)
								break;

						}

						// break;
					}
					if (entry1 == 3) {
						System.out.println("Exiting system");
						break;
					}
					if (entry1 == 4) {
						function.allEmailInSystem();
					}
					System.out.println("pleace select number mantioned bellow ");
				}
			} else {
				break;
			}

		}

	}

}
