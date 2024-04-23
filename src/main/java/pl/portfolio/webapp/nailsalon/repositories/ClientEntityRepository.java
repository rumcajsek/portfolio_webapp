package pl.portfolio.webapp.nailsalon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.portfolio.webapp.nailsalon.entities.ClientEntity;

public interface ClientEntityRepository extends JpaRepository<ClientEntity, Long> {
}
