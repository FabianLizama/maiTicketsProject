package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.tickethistoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tickethistoryRepository extends CrudRepository<tickethistoryEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
