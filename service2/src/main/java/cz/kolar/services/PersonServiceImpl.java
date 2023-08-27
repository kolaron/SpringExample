package cz.kolar.services;

import cz.kolar.entities.Person;
import cz.kolar.repositories.PersonRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl {

    private final PersonRepositoryImpl repository;

    public PersonServiceImpl(PersonRepositoryImpl repository) {
        this.repository = repository;
    }

    public Person findByUsername(String username){
        return repository.findByUsername(username);
    }

    public List<Person> addPersons(List<Person> ps) {
        return repository.saveAll(ps);
    }


    public void removePersonByID(Long id){
        repository.deleteById(id);
    }

    public Person updatePerson(Person p){
        return repository.save(p);
    }

    public List<Person> getPersons(){
        return repository.findAll();
    }

    public Optional<Person> findByID(Long ID){
        return repository.findById(ID);
    }

    public void removeAll(){
        repository.deleteAll();
    }
}
