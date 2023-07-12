package group2.FingesoProject.repositories;

import group2.FingesoProject.entitites.ticketReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticketReportRepository extends JpaRepository<ticketReportEntity, Long> {
    // JpaRepository<T,dataType> T is entity

}
