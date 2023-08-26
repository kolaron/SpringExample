package cz.kolar.repositories;

import cz.kolar.entities.BaseEntity;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
abstract public class CrudRepositoryImpl<T extends BaseEntity> implements CrudRepository<T> {

    protected EntityManager entityManager;

    public CrudRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public T add(T item) {
        entityManager.persist(item);
        return item;
    }

    @Override
    public T update(T item) {
        entityManager.merge(item);
        return item;
    }

    @Override
    public void remove(T item) {
        entityManager.remove(item);
        entityManager.flush();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T findByID(Long id) {
        return (T) entityManager.find(getEntityClass(), id);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) entityManager.createNamedQuery(String.format("%s.findAll", getEntityClass().getSimpleName())).getResultList();
    }

    protected abstract Class getEntityClass();
}
