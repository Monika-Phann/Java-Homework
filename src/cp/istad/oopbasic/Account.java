package cp.istad.oopbasic;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {
    String actNo;
    String actName;
    BigDecimal balance;
    LocalDate createAt;

    public Account(String actNO, String actName, BigDecimal balance, LocalDate createdAt) {
    }

    public Account() {

    }

    public void deposit(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Invalid amount");
        }
        balance = balance.add(amount);
    }

    public void withdrawal(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Amount must be bigger than zero");
            return;
        }

        if(amount.compareTo(balance) > 0){
            System.out.println("Insufficient amount...!");
            return;
        }

        balance = balance.subtract(amount);
    }
    public void checkBalance(){
        System.out.println("Account No: " + actNo);
        System.out.println("Account Name: " + actName);
        System.out.println("Account balance: " + balance);
        System.out.println("Account created: " + createAt);
        System.out.println();
    }
}
