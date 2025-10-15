package cp.istad.oopbasic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Scanner;

public class PayrollAccount extends Account {
    float taxRate;
    Card card;

    public PayrollAccount(String actNO, String actName, BigDecimal balance, LocalDate createdAt) {
        super(actNO, actName, balance, createdAt);
    }

    public PayrollAccount() {
        super();
    }

    public BigDecimal calculateTax(BigDecimal amount) {
        if (taxRate <= 0) return BigDecimal.ZERO;

        return amount
                .multiply(BigDecimal.valueOf(taxRate / 100))
                .setScale(3, RoundingMode.FLOOR);
    }

    @Override
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }

        BigDecimal tax = calculateTax(amount);
        BigDecimal netAmount = amount.subtract(tax);

        balance = balance.add(netAmount);

        System.out.println("Deposited: " + amount);
        System.out.println("Tax (" + taxRate + "%): " + tax);
        System.out.println("Net added to balance: " + netAmount);
    }

    @Override
    public void withdrawal(BigDecimal amount) {
        Scanner scanner = new Scanner(System.in);

        // check if card exists
        if (card == null) {
            System.out.println("No card linked to this account!");
            return;
        }

        // check if card expired
        if (card.isExpired()) {
            System.out.println("Card expired on: " + card.expiredAt);
            return;
        }

        System.out.print("Enter PIN: ");
        int inputPin = Integer.parseInt(scanner.nextLine());

        if (inputPin != card.pin) {
            System.out.println("Invalid PIN!");
            return;
        }

        if (amount.compareTo(card.overLimit) > 0) {
            System.out.println("Amount exceeds card over-limit: " + card.overLimit);
            return;
        }

        if (amount.compareTo(balance) > 0) {
            System.out.println("Insufficient funds!");
            return;
        }

        balance = balance.subtract(amount);
        System.out.println("Withdrawal successful! Amount: " + amount);
    }

    @Override
    public void checkBalance() {
        super.checkBalance();
        System.out.println("Tax Rate: " + taxRate + "%");

        if (card != null) {
            System.out.println("Card OverLimit: " + card.overLimit);
            System.out.println("Card ExpiredAt: " + card.expiredAt);
        }
    }
}
