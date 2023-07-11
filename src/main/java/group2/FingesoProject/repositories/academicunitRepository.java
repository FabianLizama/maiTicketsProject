package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.academicunitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface academicunitRepository extends JpaRepository<academicunitEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
