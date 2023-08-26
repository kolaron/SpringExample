package cz.kolar.repositories;


import jakarta.persistence.EntityManager;

public class RepositoryFactory {

    private PersonRepositoryImpl repositoryPerson;

    private static RepositoryFactory instance;

    private EntityManager entityManager;

    private RepositoryFactory(EntityManager em) {
        this.entityManager = em;
    }

    public static RepositoryFactory getInstance(EntityManager entityManager) {
        if (instance == null)
            instance = new RepositoryFactory(entityManager);
        return instance;
    }

    public PersonRepositoryImpl getRepositoryPerson() {
        if (repositoryPerson == null)
            repositoryPerson = new PersonRepositoryImpl(entityManager);
        return repositoryPerson;
    }
}
