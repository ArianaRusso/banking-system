package br.com.arianarusso.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.UUID;

public class Account {

    private UUID id;
    private String number;
    private UUID idCustomer;
    private BigDecimal balance;

    public Account(UUID id, UUID idCustomer) {
        this.id = id;
        this.number = generateRandomAccountNumber();
        this.idCustomer = idCustomer;
        this.balance = new BigDecimal(BigInteger.ZERO);
    }

    private String generateRandomAccountNumber() {
        Random random = new Random();
        int randomNumber = 100_000 + random.nextInt(900_000);
        return String.valueOf(randomNumber);
    }

    public String getNumber() {
        return number;
    }

    public UUID getIdCustomer() {
        return idCustomer;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    private void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void addFunds(BigDecimal funds){
        setBalance(this.balance.add(funds));
    }

    public void subtractFunds(BigDecimal funds){
        setBalance(this.balance.subtract(funds));
    }
}
