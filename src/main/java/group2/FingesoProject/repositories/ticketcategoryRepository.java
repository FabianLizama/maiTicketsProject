package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.ticketcategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketcategoryRepository extends JpaRepository<ticketcategoryEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
