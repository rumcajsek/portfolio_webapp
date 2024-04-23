package pl.portfolio.webapp.nailsalon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;

public interface ClientLoginEntityRepository extends JpaRepository<ClientLoginEntity, Long> {
}
