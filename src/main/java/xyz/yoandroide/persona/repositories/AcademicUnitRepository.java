package xyz.yoandroide.persona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.yoandroide.persona.entities.AcademicUnit;

@Repository
public interface AcademicUnitRepository extends JpaRepository<AcademicUnit, Long> {
}
