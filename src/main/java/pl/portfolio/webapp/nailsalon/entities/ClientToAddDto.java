package pl.portfolio.webapp.nailsalon.entities;

import lombok.Data;

@Data
public class ClientToAddDto {
    private String name;
    private String surname;
    private String email;
    private String password;
}
