package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.ticketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketRepository extends CrudRepository<ticketEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
