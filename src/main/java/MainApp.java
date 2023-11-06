import br.com.arianarusso.entities.Account;
import br.com.arianarusso.entities.Address;
import br.com.arianarusso.entities.Customer;
import br.com.arianarusso.infra.SQLConnection;
import br.com.arianarusso.infra.mappers.AccountRowMapper;
import br.com.arianarusso.infra.mappers.AddressRowMapper;
import br.com.arianarusso.infra.mappers.CustomerRowMapper;
import br.com.arianarusso.infra.mappers.EntityMapper;
import br.com.arianarusso.infra.repositories.AccountRepositoryImpl;
import br.com.arianarusso.infra.repositories.AddressRepositoryImpl;
import br.com.arianarusso.infra.repositories.CustomerRepositoryImpl;
import br.com.arianarusso.infra.repositories.GenericRepositoryImpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;


public class MainApp {
    public static void main(String[] args) throws IOException {

        SQLConnection connection = new SQLConnection();
        connection.getConnection();

        //Adress
        EntityMapper<Address> addressMapper = new AddressRowMapper();

        AddressRepositoryImpl addressRepository =
                new AddressRepositoryImpl(new GenericRepositoryImpl<>(connection,addressMapper, "address"));

        System.out.println("Lista address" + addressRepository.listAllAddress());

        UUID idAddress = UUID.fromString("5db08e9a-9a71-4c84-8d4d-a0c9419946c9");
        System.out.println("Address encontrado: " +addressRepository.findAddressById(idAddress));

        Address newAddress = new Address
                ("13271", "Rua Joao", 333, "Casa 8", "Valinhos", "SP", "Brasil");
        //addressRepository.saveAddress(newAddress);
        Address addressForUpdate = new Address
                ("54321", "Rua B", 25, "Apto 202", "Campinas", "SP", "Brasil");
        System.out.println("Update Address: "+ addressRepository.updateAddress(addressForUpdate, idAddress));
        //addressRepository.deleteAddressById(idAddress);

        //Customer
        EntityMapper<Customer> customerMapper = new CustomerRowMapper();
        CustomerRepositoryImpl customerRepository =
                new CustomerRepositoryImpl(new GenericRepositoryImpl<>(connection, customerMapper, "customer"));

        System.out.println("Lista customers: " +customerRepository.listAllCustomer());
        UUID idCustomer = UUID.fromString("28837526-d817-41b1-84a2-0657686c50b3");
        System.out.println("Customer encontrado: " +customerRepository.findCustomerById(idCustomer));

        UUID addressCustomer = UUID.fromString("d539efa7-a467-4813-8545-ae8c59125dc8");
        Customer newCustomer = new Customer("Ariana", "Russo", "35637", addressCustomer);
        //customerRepository.saveCustomer(newCustomer);

        Customer customerForUpdate = new Customer("João", "Santos", "123456", addressCustomer);

        System.out.println("Update: "+customerRepository.updateCustomer(customerForUpdate, idCustomer));
        //customerRepository.deleteCustomerById(idCustomer);

        //Account
        EntityMapper<Account> accountMapper = new AccountRowMapper();

        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl(
                new GenericRepositoryImpl<>(connection, accountMapper, "account"));


        System.out.println("Lista account: "+ accountRepository.listAllAccounts());

        UUID idAccount = UUID.fromString("b1e5c071-5c02-4597-873c-43f931bcad23");
        System.out.println("Account encontrada" + accountRepository.findAccountById(idAccount));

        UUID idCustomerForSave = UUID.fromString("2fd4069f-bd93-408a-844d-90a18dcb7f2a");
        Account newAccount = new Account(idCustomerForSave);
        //accountRepository.saveAccount(newAccount);
        UUID idAccountForUpdate = UUID.fromString("a786c00b-182e-47f3-89e2-40a4bce0ae76");
        Account accountForUpdate = new Account (new BigDecimal("200.0"), idCustomerForSave);
        //System.out.println("Update Account: " + accountRepository.updateCustomer(accountForUpdate, idAccountForUpdate));
        accountRepository.deleteAccountById(idAccountForUpdate);



    }
}
