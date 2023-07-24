package xyz.yoandroide.persona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.yoandroide.persona.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
