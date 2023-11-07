package br.com.arianarusso.infra.repositories;

import br.com.arianarusso.entities.Account;
import br.com.arianarusso.exceptions.NotFoundResourceException;

import java.util.List;
import java.util.UUID;

public class AccountRepositoryImpl {

    private GenericRepository<Account> repository;

    public AccountRepositoryImpl(GenericRepository<Account> repository) {
        this.repository = repository;
    }

    public void saveAccount(Account account){
        repository.save(account);
    }

    public Account findAccountById(UUID id){
        Account account = repository.findById(id);
        if(account == null){
            throw new NotFoundResourceException("Account not found");
        }
        return account;
    }

    public List<Account> listAllAccounts(){
       return repository.listAll();
    }

    public void deleteAccountById(UUID id){
        repository.deleteById(id);
    }

    public Account updateAccount(Account account, UUID id){

        return repository.update(account, id);
    }

    public Account findAccountByNumber(int numberAccount) {
        Account account = repository.findByNumber(numberAccount);
        if(account == null){
            throw new NotFoundResourceException("Account not found");
        }
        return account;
    }
}
