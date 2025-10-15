package cp.istad.oopbasic;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Card {
    int pin;
    BigDecimal overLimit;
    LocalDate expiredAt;

    public Card(int pin, BigDecimal overLimit, LocalDate expiredAt) {
        this.pin = pin;
        this.overLimit = overLimit;
        this.expiredAt = expiredAt;
    }

    public Card() {}

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiredAt);
    }
}
