package pl.portfolio.webapp.nailsalon.mappers;

import pl.portfolio.webapp.nailsalon.entities.ClientEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientUserRole;
import pl.portfolio.webapp.nailsalon.entities.dtos.FullClientDataDto;

public class ClientToDtoMapper {
    public static FullClientDataDto MapEntityToDto(ClientLoginEntity clientLoginEntity) {
        ClientEntity clientEntity = clientLoginEntity.getClientData();
        new FullClientDataDto();
        return FullClientDataDto.builder()
                .client_id(clientEntity.getId())
                .name(clientEntity.getName())
                .surname(clientEntity.getSurname())
                .login_data_id(clientLoginEntity.getId())
                .email(clientLoginEntity.getEmail())
                .password(clientLoginEntity.getPassword())
                .userRoles(clientLoginEntity.getUserRoleSet().stream()
                        .map(ClientUserRole::getName).toList())
                .build();
    }
}
