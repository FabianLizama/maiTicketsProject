package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.tickethistoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tickethistoryRepository extends JpaRepository<tickethistoryEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
