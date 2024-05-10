package pl.portfolio.webapp.nailsalon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.portfolio.webapp.nailsalon.entities.ClientUserRole;

import java.util.Optional;

public interface ClientUserRoleRepository extends JpaRepository<ClientUserRole, Long> {
    Optional<ClientUserRole> findByName(String name);
}
