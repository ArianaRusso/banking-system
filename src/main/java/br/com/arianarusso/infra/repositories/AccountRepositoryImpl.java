package br.com.arianarusso.infra.repositories;

import br.com.arianarusso.entities.Account;
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
        return repository.findById(id);
    }

    public List<Account> listAllAccounts(){

       return repository.listAll();
    }

    public void deleteAccountById(UUID id){
        repository.deleteById(id);
    }

    public Account updateCustomer(Account account, UUID id){

        return repository.update(account, id);
    }
}
