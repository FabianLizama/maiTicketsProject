package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.ticketcomentaryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketcomentaryRepository extends CrudRepository<ticketcomentaryEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
