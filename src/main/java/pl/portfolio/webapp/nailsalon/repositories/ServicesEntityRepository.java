package pl.portfolio.webapp.nailsalon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.portfolio.webapp.nailsalon.entities.ServicesEntity;

import java.util.Optional;

public interface ServicesEntityRepository extends JpaRepository<ServicesEntity, Long> {
    Optional<ServicesEntity> findByName(String name);
}
