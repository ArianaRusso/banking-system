package br.com.arianarusso.accountaccess.services;

import br.com.arianarusso.accountaccess.entities.Account;
import br.com.arianarusso.accountaccess.exceptions.BusinessRuleException;
import br.com.arianarusso.accountaccess.infra.repositories.AccountRepositoryImpl;

import java.math.BigDecimal;

public class TransactionService implements PaymentGateway{

    private AccountRepositoryImpl accountRepository;

    public TransactionService(AccountRepositoryImpl accountRepository) {
        this.accountRepository = accountRepository;
    }

    public BigDecimal checkAccountBalance (int accountNumber){
        Account account = accountRepository.findAccountByNumber(accountNumber);
        return account.getBalance();
    }

    public void payIn (int accountNumber, BigDecimal value){
        Account account = accountRepository.findAccountByNumber(accountNumber);
        if(value.compareTo(BigDecimal.ZERO) <= 0){
            throw new BusinessRuleException("Value must be greater than zero");
        }

        BigDecimal newBalance = account.getBalance().add(value);
        this.alter(account, newBalance);
    }

    public void withDraw (int accountNumber, BigDecimal value){
        Account account = accountRepository.findAccountByNumber(accountNumber);
        if(value.compareTo(BigDecimal.ZERO) <= 0){
            throw new BusinessRuleException("Value must be greater than zero");
        }
        if(value.compareTo(account.getBalance()) > 0){
            throw new BusinessRuleException("Insufficient funds");
        }

        BigDecimal newBalance = account.getBalance().subtract(value);
        this.alter(account, newBalance);

    }

    public void transferValue (int accountNumberSender, int accountNumberReceiver, BigDecimal value){
        this.withDraw(accountNumberSender, value);
        this.payIn(accountNumberReceiver, value);
    }

    private void alter(Account account, BigDecimal value){
        Account updatedAccount = new Account(account.getId(), account.getNumber(), value, account.getCustomerId());
        accountRepository.updateAccount(updatedAccount, updatedAccount.getId());
    }
}
