package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<userEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
