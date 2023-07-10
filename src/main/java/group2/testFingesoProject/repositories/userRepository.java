package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.userEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends CrudRepository<userEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
