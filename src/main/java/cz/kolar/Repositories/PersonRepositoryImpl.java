package cz.kolar.Repositories;

import cz.kolar.Entities.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PersonRepositoryImpl extends CrudRepositoryImpl<Person> implements PersonRepository<Person> {

    public PersonRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @SuppressWarnings(value = "unchecked")
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
