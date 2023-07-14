package xyz.yoandroide.persona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.yoandroide.persona.entities.Leadership;

@Repository
public interface LeadershipRepository extends JpaRepository<Leadership, Long> {
}
