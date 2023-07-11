package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.externalclientEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface externalclientRepository extends JpaRepository<externalclientEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
