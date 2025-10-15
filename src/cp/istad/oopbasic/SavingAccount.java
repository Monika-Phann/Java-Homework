package cp.istad.oopbasic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

public class SavingAccount extends Account {
    float interestRate;
    Card card;

    public SavingAccount(String actNO, String actName, BigDecimal balance, LocalDate createdAt){
        super(actNO, actName, balance, createdAt);
        this.calculateInterest();

    }

    public SavingAccount() {
        super();
    }

    public BigDecimal calculateInterest(){
        int years = Period.between(createAt, LocalDate.now()).getYears();
        if (years >= 1 )
            return balance
                    .multiply(BigDecimal.valueOf(interestRate/100))
                    .setScale(3, RoundingMode.FLOOR);
        else{
            return BigDecimal.ZERO;
        }
    }

    @Override
    public void deposit(BigDecimal amount) {
        super.deposit(amount);
    }

    @Override
    public void withdrawal(BigDecimal amount) {
        super.withdrawal(amount);
    }

    @Override
    public void checkBalance() {
        super.checkBalance();
        System.out.println("Interest Rate: " + interestRate);
        System.out.println("Interest: " + calculateInterest());
    }

}
