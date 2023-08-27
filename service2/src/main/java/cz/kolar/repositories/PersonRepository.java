package cz.kolar.repositories;

import cz.kolar.entities.Person;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonRepository extends CrudRepository<Person>{

    Person findByUsername(String username);
}
