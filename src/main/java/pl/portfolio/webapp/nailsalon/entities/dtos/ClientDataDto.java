package pl.portfolio.webapp.nailsalon.entities.dtos;

import lombok.Builder;
import lombok.Data;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class ClientDataDto {
    private Long id;
    private String email;
    private String password;
    private ClientEntityDto clientEntityDto;
    private Set<ClientUserRoleDto> clientUserRoleDtoSet;
    private Set<AppointmentDto> appointmentDtoSet;

    public ClientDataDto(ClientLoginEntity clientLoginEntity) {
        this.id = clientLoginEntity.getId();
        this.email = clientLoginEntity.getEmail();
        this.password = clientLoginEntity.getPassword();
        this.clientEntityDto = new ClientEntityDto(clientLoginEntity.getClientData().getId(),
                clientLoginEntity.getClientData().getName(),
                clientLoginEntity.getClientData().getSurname());
        this.clientUserRoleDtoSet = clientLoginEntity.getUserRoleSet().stream()
                .map(role -> new ClientUserRoleDto(role.getName(), role.getDescription()))
                .collect(Collectors.toSet());
        this.appointmentDtoSet = clientLoginEntity.getClientData().getAppointmentEntitySet().stream()
                .map(appt -> new AppointmentDto(appt.getId(),
                        null,
                        new ServicesDto(appt.getServicesEntity().getName(), appt.getServicesEntity().getDescription(), appt.getServicesEntity().getDuration(), appt.getServicesEntity().getCost()),
                        appt.getDate()))
                .collect(Collectors.toSet());
    }
}
