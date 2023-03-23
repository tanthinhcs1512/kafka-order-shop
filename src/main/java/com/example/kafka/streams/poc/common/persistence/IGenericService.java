package com.example.kafka.streams.poc.common.persistence;

public interface IGenericService<T> {

    T save(T t);

    T findById(long id);

    void delete(T t);

    void deleteById(long id);

    long count();
}
