package pl.portfolio.webapp.nailsalon.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientLoginDataDto {
    private String email;
    private String password;
    private Set<ClientUserRole> userRoleSet = new HashSet<>();
}
