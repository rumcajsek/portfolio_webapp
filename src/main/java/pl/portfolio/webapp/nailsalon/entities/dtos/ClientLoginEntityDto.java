package pl.portfolio.webapp.nailsalon.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.portfolio.webapp.nailsalon.entities.ClientUserRole;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientLoginEntityDto {
    private String email;
    private String password;
    private Set<ClientUserRole> userRoleSet = new HashSet<>();
}
