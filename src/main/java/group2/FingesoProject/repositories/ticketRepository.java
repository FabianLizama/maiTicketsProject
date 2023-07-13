package group2.FingesoProject.repositories;

import group2.FingesoProject.entities.ticketEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketRepository extends JpaRepository<ticketEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
