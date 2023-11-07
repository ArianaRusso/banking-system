//package br.com.arianarusso.accountaccess.infra.repositories;
//
//import br.com.arianarusso.accountaccess.entities.Address;
//import java.util.*;
//
//
//public class AddressRepositoryImpl {
//
//    private GenericRepository<Address> repository;
//
//    public AddressRepositoryImpl(GenericRepository<Address> repository) {
//        this.repository = repository;
//    }
//
//    public void saveAddress(Address address){
//        repository.save(address);
//    }
//
//    public Address findAddressById(UUID id){
//        return repository.findById(id);
//    }
//
//    public List<Address> listAllAddress(){
//        return repository.listAll();
//    }
//
//    public void deleteAddressById(UUID id){
//        repository.deleteById(id);
//    }
//
//    public Address updateAddress(Address address, UUID id){
//
//        return repository.update(address, id);
//    }
//
//}
