package xyz.yoandroide.persona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.yoandroide.persona.entities.Analyzer;

@Repository
public interface AnalyzerRepository extends JpaRepository<Analyzer, Long> {
}
