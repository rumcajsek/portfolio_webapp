package pl.portfolio.webapp.nailsalon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.portfolio.webapp.nailsalon.entities.ServicesEntity;

public interface ServicesEntityRepository extends JpaRepository<ServicesEntity, Long> {
}
