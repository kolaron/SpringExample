package cz.kolar.config;

import cz.kolar.repositories.PersonRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "cz.kolar.repositories", repositoryBaseClass = PersonRepositoryImpl.class)
public class PersonJPAConfig {
}
