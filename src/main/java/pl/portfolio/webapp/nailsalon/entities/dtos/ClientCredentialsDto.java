package pl.portfolio.webapp.nailsalon.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientCredentialsDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Set<String> userRoles;
}
