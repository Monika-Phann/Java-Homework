package cp.istad.oopbasic;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SavingAccount savingAccount = new SavingAccount();
        savingAccount.actNo = "12345";
        savingAccount.actName = "MONIKA";
        savingAccount.balance = BigDecimal.valueOf(30);
        savingAccount.createAt = LocalDate.of(2020, 10, 10);
        savingAccount.interestRate = 9;

        PayrollAccount payrollAccount = new PayrollAccount();
        payrollAccount.actNo = "99999";
        payrollAccount.actName = "MONIKA PAYROLL";
        payrollAccount.balance = BigDecimal.valueOf(500);
        payrollAccount.createAt = LocalDate.of(2021, 5, 10);
        payrollAccount.taxRate = 10;

        Card card = new Card(1234, BigDecimal.valueOf(200), LocalDate.of(2026, 12, 31));
        payrollAccount.card = card;

        do {
            System.out.println("-------------------------");
            System.out.println("Welcome to Banking system");
            System.out.println("-------------------------");
            System.out.println("Select Account Type:");
            System.out.println("1. Saving Account");
            System.out.println("2. Payroll Account");
            System.out.println("0. Exit");
            System.out.print("Enter option: ");
            int accountOption = Integer.parseInt(scanner.nextLine());

            if (accountOption == 0) {
                System.exit(0);
            }

            Account currentAccount;
            if (accountOption == 1) {
                currentAccount = savingAccount;
            } else if (accountOption == 2) {
                currentAccount = payrollAccount;
            } else {
                System.out.println("Invalid option. Try again.");
                continue;
            }

            System.out.println("-------------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawal");
            System.out.println("3. Check Balance");
            if (currentAccount instanceof SavingAccount) {
                System.out.println("4. InterestRate");
            }
            System.out.println("0. Back");

            System.out.print("Enter option: ");
            int option = Integer.parseInt(scanner.nextLine());
            System.out.println("-------------");

            switch (option) {
                case 1 -> {
                    System.out.print("Enter amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    currentAccount.deposit(BigDecimal.valueOf(amount));
                }
                case 2 -> {
                    System.out.print("Enter amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    currentAccount.withdrawal(BigDecimal.valueOf(amount));
                }
                case 3 -> currentAccount.checkBalance();
                case 4 -> {
                    if (currentAccount instanceof SavingAccount savingAcc) {
                        System.out.println("Interest: " + savingAcc.calculateInterest());
                    } else {
                        System.out.println("Invalid option for this account type.");
                    }
                }
                case 0 -> {
                }
                default -> System.out.println("Invalid option. Try again.");
            }

        } while (true);
    }
}
