package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.clientpriorityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientpriorityRepository extends CrudRepository<clientpriorityEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
