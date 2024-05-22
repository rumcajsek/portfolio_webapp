package pl.portfolio.webapp.nailsalon.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntityDto {
    private String name;
    private String surname;
}