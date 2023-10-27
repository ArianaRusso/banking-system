package br.com.arianarusso.infra;

import java.util.List;
import java.util.UUID;

public interface GenericRepository <T>{
    void salve(T t);
    T findById(UUID id);
    List<T> listAll();
    void deleteById (UUID id);
}
