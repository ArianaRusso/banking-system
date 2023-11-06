package br.com.arianarusso.services;

import br.com.arianarusso.entities.Account;
import br.com.arianarusso.exceptions.BusinessRuleException;
import br.com.arianarusso.infra.repositories.AccountRepositoryImpl;

import java.math.BigDecimal;

public class TransactionService implements PaymentGateway{

    private AccountRepositoryImpl accountRepository;

    public TransactionService(AccountRepositoryImpl accountRepository) {
        this.accountRepository = accountRepository;
    }

    public BigDecimal checkAccountBalance (int numberAccount){
        Account account = accountRepository.findAccountByNumber(numberAccount);
        return account.getBalance();
    }

    public void payIn (int numberAccount, BigDecimal value){
        Account account = accountRepository.findAccountByNumber(numberAccount);
        if(value.compareTo(BigDecimal.ZERO) <= 0){
            throw new BusinessRuleException("Value must be greater than zero");
        }

        BigDecimal newBalance = account.getBalance().add(value);
        this.alter(account, newBalance);
    }

    public void withDraw (int numberAccount, BigDecimal value){
        Account account = accountRepository.findAccountByNumber(numberAccount);
        if(value.compareTo(BigDecimal.ZERO) <= 0){
            throw new BusinessRuleException("Value must be greater than zero");
        }
        if(value.compareTo(account.getBalance()) > 0){
            throw new BusinessRuleException("Insufficient funds");
        }

        BigDecimal newBalance = account.getBalance().subtract(value);
        this.alter(account, newBalance);

    }

    public void transferValue (int numberAccountSender, int numberAccountReceiver, BigDecimal value){
        this.withDraw(numberAccountSender, value);
        this.payIn(numberAccountReceiver, value);
    }

    private void alter(Account account, BigDecimal value){
        Account updatedAccount = new Account(account.getId(), account.getNumber(), value, account.getCustomerId());
        accountRepository.updateCustomer(updatedAccount, updatedAccount.getId());
    }
}
