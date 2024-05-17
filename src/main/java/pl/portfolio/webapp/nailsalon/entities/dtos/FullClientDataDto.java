package pl.portfolio.webapp.nailsalon.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FullClientDataDto {
    private Long client_id;
    private String name;
    private String surname;
    private Long login_data_id;
    private String email;
    private String password;
    private List<String> userRoles;
}
