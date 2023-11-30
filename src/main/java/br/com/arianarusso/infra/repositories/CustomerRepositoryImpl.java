package br.com.arianarusso.infra.repositories;
import br.com.arianarusso.entities.Customer;
import java.util.List;
import java.util.UUID;

public class CustomerRepositoryImpl {

    private GenericRepository<Customer> repository;

    public CustomerRepositoryImpl(GenericRepository<Customer> repository) {
        this.repository = repository;
    }

    public void saveCustomer(Customer customer){
        repository.save(customer);
    }

    public Customer findCustomerById(UUID id){
        return repository.findById(id);
    }

    public List<Customer> listAllCustomer(){
        return repository.listAll();
    }

    public void deleteCustomerById(UUID id){
        repository.deleteById(id);
    }

    public Customer updateCustomer(Customer customer, UUID id){

        return repository.update(customer, id);
    }
}
