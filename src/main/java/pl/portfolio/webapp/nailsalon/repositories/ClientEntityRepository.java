package pl.portfolio.webapp.nailsalon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.portfolio.webapp.nailsalon.entities.ClientEntity;

import java.util.Optional;

public interface ClientEntityRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByNameAndSurname(String name, String surname);
}
