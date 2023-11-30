package br.com.arianarusso.services;

import br.com.arianarusso.dtos.AccountOpeningData;
import br.com.arianarusso.entities.Account;
import br.com.arianarusso.entities.Address;
import br.com.arianarusso.entities.Customer;
import br.com.arianarusso.infra.repositories.AccountRepositoryImpl;
import br.com.arianarusso.infra.repositories.AddressRepositoryImpl;
import br.com.arianarusso.infra.repositories.CustomerRepositoryImpl;

public class AccountManagementService {

    private AccountRepositoryImpl accountRepository;
    private AddressRepositoryImpl addressRepository;
    private CustomerRepositoryImpl customerRepository;


    public AccountManagementService
            (AccountRepositoryImpl accountRepository, AddressRepositoryImpl addressRepository,
             CustomerRepositoryImpl customerRepository) {
        this.accountRepository = accountRepository;
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
    }

    public void createAccount(AccountOpeningData openingData){
        Address address = new Address(
                openingData.postalCode(),
                openingData.street(),
                openingData.number(),
                openingData.complement(),
                openingData.city(),
                openingData.state(),
                openingData.country()
        );
        addressRepository.saveAddress(address);

        Customer customer = new Customer(
                openingData.firstName(),
                openingData.lastName(),
                openingData.document(),
                address.getId()
        );
        customerRepository.saveCustomer(customer);

        Account account = new Account(customer.getId());
        accountRepository.saveAccount(account);

    }

    public void closeAccount(int accountNumber){
        Account account = accountRepository.findAccountByNumber(accountNumber);
        accountRepository.deleteAccountById(account.getId());
    }
}
