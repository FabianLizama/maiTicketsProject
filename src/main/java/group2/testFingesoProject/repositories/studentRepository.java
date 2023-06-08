package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.studentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends CrudRepository<studentEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
