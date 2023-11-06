package br.com.arianarusso.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

public class Account {

    private UUID id;
    private int number;
    private BigDecimal balance;
    private UUID customerId;


    public Account(UUID customerId) {
        this.balance = new BigDecimal(BigInteger.ZERO);
        this.customerId = customerId;

    }
    public Account(BigDecimal balance, UUID customerId) {
        this.balance = balance;
        this.customerId = customerId;

    }

    public Account(UUID id, int number, BigDecimal balance, UUID idCustomer) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.customerId = idCustomer;

    }

    public Account() {
    }

    public UUID getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", idCustomer=" + customerId +
                ", balance=" + balance +
                '}';
    }
}
