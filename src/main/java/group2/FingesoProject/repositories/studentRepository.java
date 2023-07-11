package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.studentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<studentEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
