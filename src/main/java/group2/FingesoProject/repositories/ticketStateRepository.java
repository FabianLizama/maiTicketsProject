package group2.FingesoProject.repositories;

import group2.FingesoProject.entities.ticketStateEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketStateRepository extends JpaRepository<ticketStateEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
