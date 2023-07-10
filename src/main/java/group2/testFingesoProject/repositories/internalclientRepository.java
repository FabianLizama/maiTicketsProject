package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.internalclientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface internalclientRepository extends CrudRepository<internalclientEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
