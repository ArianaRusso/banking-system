package br.com.arianarusso.dtos;

import br.com.arianarusso.entities.Account;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentData {
    private Account receivingAccount;
    private BigDecimal value;
    private Date date;

    public PaymentData(Account receivingAccount, BigDecimal value, Date date) {
        this.receivingAccount = receivingAccount;
        this.value = value;
        this.date = date;
    }

    public Account getReceivingAccount() {
        return receivingAccount;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }
}
