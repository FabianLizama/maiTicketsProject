package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.academicunitEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface academicunitRepository extends CrudRepository<academicunitEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
