package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.ticketpriorityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketpriorityRepository extends CrudRepository<ticketpriorityEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
