package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.user_infoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface user_infoRepository extends JpaRepository<user_infoEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
