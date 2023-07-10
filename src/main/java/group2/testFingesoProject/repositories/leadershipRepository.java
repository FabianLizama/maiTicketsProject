package group2.testFingesoProject.repositories;

import group2.testFingesoProject.entitites.leadershipEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface leadershipRepository extends CrudRepository<leadershipEntity, Long> {
    // CrudRepository<T,dataType> T is entity

}
