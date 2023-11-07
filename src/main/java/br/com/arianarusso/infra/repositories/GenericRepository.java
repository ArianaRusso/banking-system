package br.com.arianarusso.infra.repositories;


import java.util.List;
import java.util.UUID;


public interface GenericRepository <T>{
    void save(T t);
    T findById(UUID id);
    List<T> listAll();
    void deleteById(UUID id);
    T update(T t, UUID id);

    T findByNumber(int number);
}
