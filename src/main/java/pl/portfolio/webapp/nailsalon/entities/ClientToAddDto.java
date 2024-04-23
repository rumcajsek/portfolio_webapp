package pl.portfolio.webapp.nailsalon.entities;

import lombok.Data;

@Data
public class ClientToAddDto {
    private String email;
    private String password;
    private String name;
    private String surname;
}
