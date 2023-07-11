package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.ticketcomentaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketcomentaryRepository extends JpaRepository<ticketcomentaryEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
