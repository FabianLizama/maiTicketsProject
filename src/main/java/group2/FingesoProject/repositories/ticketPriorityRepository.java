package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.ticketPriorityEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketPriorityRepository extends JpaRepository<ticketPriorityEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
