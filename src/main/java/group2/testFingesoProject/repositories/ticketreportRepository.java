package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.ticketreportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketreportRepository extends CrudRepository<ticketreportEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
