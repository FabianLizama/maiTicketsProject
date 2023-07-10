package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.ticketstateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketstateRepository extends CrudRepository<ticketstateEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
