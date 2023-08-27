package cz.kolar.repositories;

import cz.kolar.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CrudRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
