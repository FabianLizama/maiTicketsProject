package group2.FingesoProject.repositories;

import group2.FingesoProject.entities.externalClientEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface externalClientRepository extends JpaRepository<externalClientEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
