package cz.kolar.repositories;

import cz.kolar.entities.Person;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImpl extends CrudRepositoryImpl<Person> implements PersonRepository<Person> {

    public PersonRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Person findByUsername(String username) {
        List<Person> resultList = entityManager.createNamedQuery(getEntityClass().getSimpleName() + ".findByUsername").setParameter("username", username).getResultList();
        if (resultList == null || resultList.get(0) == null)
            return null;
        return resultList.get(0);
    }

    @Override
    protected Class getEntityClass() {
        return Person.class;
    }
}
