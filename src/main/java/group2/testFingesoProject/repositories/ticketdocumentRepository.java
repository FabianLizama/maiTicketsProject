package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.ticketdocumentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketdocumentRepository extends CrudRepository<ticketdocumentEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
