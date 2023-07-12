package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.ticketCategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketCategoryRepository extends JpaRepository<ticketCategoryEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
