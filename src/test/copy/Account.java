package test.copy;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
public class Account implements Serializable {

    private String number;

    private BigDecimal amount;

    public Account(String number, BigDecimal amount) {
        this.number = number;
        this.amount = amount;
    }
}
