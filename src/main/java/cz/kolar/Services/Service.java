package cz.kolar.Services;

import cz.kolar.Entities.Person;

import java.util.List;

public interface Service {
    Person addPerson(Person p);

    List<Person> addPersons(List<Person> ps);

    void removePerson(Person p);

    void removePersonByID(Long id);

    Person updatePerson(Person p);

    List<Person> getPersons();

    Person findByID(Long ID);

    void removeAll();
}
