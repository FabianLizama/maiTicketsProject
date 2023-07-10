package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.ticketcategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketcategoryRepository extends CrudRepository<ticketcategoryEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
