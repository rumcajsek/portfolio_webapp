package pl.portfolio.webapp.nailsalon.entities.dtos;

import lombok.Data;

@Data
public class ServicesDto {
    private String name;
    private String description;
    private float duration;
    private float cost;
}
