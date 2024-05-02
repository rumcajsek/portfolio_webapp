package pl.portfolio.webapp.nailsalon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.portfolio.webapp.nailsalon.entities.AppointmentEntity;

public interface AppointmentEntityRepository extends JpaRepository<AppointmentEntity, Long> {
}
