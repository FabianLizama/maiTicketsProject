package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.ticketstateEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketstateRepository extends JpaRepository<ticketstateEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
