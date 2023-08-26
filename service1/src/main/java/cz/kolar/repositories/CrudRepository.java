package cz.kolar.repositories;

import cz.kolar.entities.BaseEntity;

import java.util.List;

public interface CrudRepository<T extends BaseEntity> {
    T add(T item);

    T update(T item);

    void remove(T item);

    T findByID(Long id);

    List<T> findAll();
}
