package cz.kolar.repositories;

import cz.kolar.entities.Person;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class PersonRepositoryImpl extends SimpleJpaRepository<Person, Long> implements PersonRepository {

    private final EntityManager entityManager;

    public PersonRepositoryImpl(Class<Person> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }

    public PersonRepositoryImpl(JpaEntityInformation<Person, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Person findByUsername(String username) {
        return (Person) entityManager.createNamedQuery("Person.findByUsername").setParameter("username", username).getSingleResult();
    }
}
