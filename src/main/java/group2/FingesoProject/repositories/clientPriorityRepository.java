package group2.FingesoProject.repositories;

import group2.FingesoProject.entities.clientPriorityEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientPriorityRepository extends JpaRepository<clientPriorityEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
