package cz.kolar.Repositories;

import cz.kolar.Entities.BaseEntity;

public interface PersonRepository<T extends BaseEntity> {
    T findByUsername(String username);
}
