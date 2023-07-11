package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.ticketpriorityEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketpriorityRepository extends JpaRepository<ticketpriorityEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
