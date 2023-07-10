package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.ticketratingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketratingRepository extends CrudRepository<ticketratingEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
