package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.externalclientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface externalclientRepository extends CrudRepository<externalclientEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
