package cz.kolar.repositories;


import cz.kolar.entities.BaseEntity;

public interface PersonRepository<T extends BaseEntity> {
    T findByUsername(String username);
}
