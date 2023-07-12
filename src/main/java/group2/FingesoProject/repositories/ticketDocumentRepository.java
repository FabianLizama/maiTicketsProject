package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.ticketDocumentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketDocumentRepository extends JpaRepository<ticketDocumentEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
