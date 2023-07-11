package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.analyzerEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface analyzerRepository extends JpaRepository<analyzerEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
