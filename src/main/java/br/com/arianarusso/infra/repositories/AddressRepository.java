package br.com.arianarusso.infra.repositories;

import br.com.arianarusso.entities.Address;

import java.util.*;

public class AddressRepository implements GenericRepository<Address> {

    //GenericDAO ou AddressDAO?

    private HashMap<UUID, Address> repository;

    public AddressRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void salve(Address address) {
        //repository.put(address.getId, address);
    }

    @Override
    public Address findById(UUID id) {
        return repository.get(id);
    }

    @Override
    public List<Address> listAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public void deleteById(UUID id) {
        repository.remove(id);
    }

    @Override
    public Address update(Address address, UUID id) {
        return repository.replace(id, address);
    }
}
