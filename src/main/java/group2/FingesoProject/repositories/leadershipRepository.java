package group2.FingesoProject.repositories;

import group2.FingesoProject.entities.leadershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface leadershipRepository extends JpaRepository<leadershipEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
