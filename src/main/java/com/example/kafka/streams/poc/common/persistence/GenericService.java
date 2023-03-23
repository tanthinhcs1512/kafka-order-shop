package com.example.kafka.streams.poc.common.persistence;

import java.io.Serializable;

public class GenericService<T extends Serializable> implements IGenericService<T> {

    GenericDao<T> dao;

    @Override
    public T save(final T t) {
        return dao.save(t);
    }

    @Override
    public T findById(final long id) {
        return dao.findById(id);
    }

    @Override
    public void delete(T t) {
        dao.delete(t);
    }

    @Override
    public void deleteById(final long id) {
        dao.deleteById(id);
    }

    @Override
    public long count() {
        return 0;
    }
}
