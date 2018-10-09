package cz.kolar.Services;

import cz.kolar.Entities.Person;
import cz.kolar.Repositories.RepositoryFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Person addPerson(Person p) {
        return RepositoryFactory.getInstance(entityManager).getRepositoryPerson().add(p);
    }

    @Transactional
    @Override
    public List<Person> addPersons(List<Person> ps) {
        List<Person> resultList = new ArrayList<>();
        ps.forEach(person -> resultList.add(RepositoryFactory.getInstance(entityManager).getRepositoryPerson().add(person)));
        return resultList;
    }

    @Override
    public void removePerson(Person p) {
        RepositoryFactory.getInstance(entityManager).getRepositoryPerson().remove(p);
    }

    @Transactional
    @Override
    public List<Person> getPersons() {
        return RepositoryFactory.getInstance(entityManager).getRepositoryPerson().findAll();
    }

    @Transactional
    @Override
    public Person updatePerson(Person p) {
        return RepositoryFactory.getInstance(entityManager).getRepositoryPerson().update(p);
    }

    @Override
    public Person findByID(Long ID) {
        return RepositoryFactory.getInstance(entityManager).getRepositoryPerson().findByID(ID);
    }

    @Transactional
    @Override
    public void removePersonByID(Long id) {
        Person person = RepositoryFactory.getInstance(entityManager).getRepositoryPerson().findByID(id);
        if (person != null)
            RepositoryFactory.getInstance(entityManager).getRepositoryPerson().remove(person);
    }

    @Transactional
    @Override
    public void removeAll() {
        List<Person> personList = RepositoryFactory.getInstance(entityManager).getRepositoryPerson().findAll();
        personList.forEach((person -> RepositoryFactory.getInstance(entityManager).getRepositoryPerson().remove(person)));
    }
}
