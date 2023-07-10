package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.analyzerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface analyzerRepository extends CrudRepository<analyzerEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
