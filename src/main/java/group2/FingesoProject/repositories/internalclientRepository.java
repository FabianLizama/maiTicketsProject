package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.internalclientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface internalclientRepository extends JpaRepository<internalclientEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
