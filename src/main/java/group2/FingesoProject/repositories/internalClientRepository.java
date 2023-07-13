package group2.FingesoProject.repositories;

import group2.FingesoProject.entities.internalClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface internalClientRepository extends JpaRepository<internalClientEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
