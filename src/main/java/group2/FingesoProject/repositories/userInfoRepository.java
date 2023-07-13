package group2.FingesoProject.repositories;

import group2.FingesoProject.entities.userInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userInfoRepository extends JpaRepository<userInfoEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
