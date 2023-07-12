package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.ticketRatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketRatingRepository extends JpaRepository<ticketRatingEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
