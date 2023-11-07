package br.com.arianarusso.accountaccess.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

@Entity
@Table(name = "tb_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int number;

    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Account(Customer customer) {
        this.balance = new BigDecimal(BigInteger.ZERO);
        this.customer = customer;

    }
    public Account(BigDecimal balance, Customer customer) {
        this.balance = balance;
        this.customer = customer;

    }

    public Account(UUID id, int number, BigDecimal balance, Customer customer) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.customer = customer;

    }

    public Account() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", customer_id=" + customer +
                ", balance=" + balance +
                '}';
    }
}
