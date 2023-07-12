package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.ticketComentaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketComentaryRepository extends JpaRepository<ticketComentaryEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
