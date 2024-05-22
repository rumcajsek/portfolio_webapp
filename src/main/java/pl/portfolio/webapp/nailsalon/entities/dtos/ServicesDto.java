package pl.portfolio.webapp.nailsalon.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicesDto {
    private String name;
    private String description;
    private float duration;
    private float cost;
}
