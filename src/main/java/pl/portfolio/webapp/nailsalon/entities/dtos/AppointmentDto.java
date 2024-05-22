package pl.portfolio.webapp.nailsalon.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private Long id;
    private ClientEntityDto clientEntityDto;
    private ServicesDto servicesDto;
    private LocalDateTime date;
}
