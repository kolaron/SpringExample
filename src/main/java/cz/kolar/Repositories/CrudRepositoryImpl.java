package cz.kolar.Repositories;

import cz.kolar.Entities.BaseEntity;

import javax.persistence.EntityManager;
import java.util.List;

@org.springframework.stereotype.Repository
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

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        return (List<T>) entityManager.createNamedQuery(String.format("%s.findAll", getEntityClass().getSimpleName())).getResultList();
    }

    protected abstract Class getEntityClass();
}
