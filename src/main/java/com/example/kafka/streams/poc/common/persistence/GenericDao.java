package com.example.kafka.streams.poc.common.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public abstract class GenericDao<T extends Serializable> {

    private Class<T> clazz = getClazz();

    protected abstract Class<T> getClazz();

    @PersistenceContext
    public EntityManager entityManager;

    public T findById(long id) {
        T t = (T) entityManager.find(clazz, id);
        return t;
    }

    public T save(final T t) {
        entityManager.persist(t);
        return t;
    }

    public T update(final T t) {
        entityManager.merge(t);
        return t;
    }

    public void delete(final T t) {
        entityManager.remove(t);
    }

    public void deleteById(final long id) {
        final T t = findById(id);
        delete(t);
    }
}
