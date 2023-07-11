package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.ticketdocumentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketdocumentRepository extends JpaRepository<ticketdocumentEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
