package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.academicUnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface academicUnitRepository extends JpaRepository<academicUnitEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
