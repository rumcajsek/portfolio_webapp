package pl.portfolio.webapp.nailsalon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.portfolio.webapp.nailsalon.entities.ClientUserRole;

public interface ClientUserRoleRepository extends JpaRepository<ClientUserRole, Long> {
    ClientUserRole findByName(String name);
}
