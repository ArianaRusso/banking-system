package br.com.arianarusso.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

public class Account {

    private UUID id;
    private String number;
    private UUID idCustomer;
    private BigDecimal balance;

    public Account(UUID id, String number, UUID idCustomer) {
        this.id = id;
        this.number = number;
        this.idCustomer = idCustomer;
        this.balance = new BigDecimal(BigInteger.ZERO);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UUID getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(UUID idCustomer) {
        this.idCustomer = idCustomer;
    }

    public BigDecimal getBalance() {
        return balance;
    }

}
