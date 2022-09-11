package com.example.practicumfirstcase.service;

import java.util.List;
import java.util.Optional;

public interface IService <T ,ID>{

    T save(T entity);
    Iterable<T> saveAll(Iterable<T> entities);
    T update(ID id,T entity);
    void deleteById(ID id);
    Optional<T> findById(ID id);
    List<T> findAll();
}
