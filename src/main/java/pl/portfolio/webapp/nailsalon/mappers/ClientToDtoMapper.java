package pl.portfolio.webapp.nailsalon.mappers;

import pl.portfolio.webapp.nailsalon.entities.ClientEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientUserRole;
import pl.portfolio.webapp.nailsalon.entities.dtos.ClientCredentialsDto;
import pl.portfolio.webapp.nailsalon.entities.dtos.FullClientDataDto;

import java.util.stream.Collectors;

public class ClientToDtoMapper {
    public static FullClientDataDto MapEntityToDto(ClientLoginEntity clientLoginEntity) {
        ClientEntity clientEntity = clientLoginEntity.getClientData();
        return FullClientDataDto.builder()
                .client_id(clientEntity.getId())
                .name(clientEntity.getName())
                .surname(clientEntity.getSurname())
                .login_data_id(clientLoginEntity.getId())
                .email(clientLoginEntity.getEmail())
                .password(clientLoginEntity.getPassword())
                .userRoles(clientLoginEntity.getUserRoleSet().stream()
                        .map(ClientUserRole::getName)
                        .collect(Collectors.toSet()))
                .build();
    }

    public static ClientCredentialsDto MapCredentialsToDto(ClientLoginEntity clientLoginEntity) {
        ClientEntity clientEntity = clientLoginEntity.getClientData();
        return ClientCredentialsDto.builder()
                .name(clientEntity.getName())
                .surname(clientEntity.getSurname())
                .email(clientLoginEntity.getEmail())
                .password(clientLoginEntity.getPassword())
                .userRoles(clientLoginEntity.getUserRoleSet().stream()
                        .map(ClientUserRole::getName)
                        .collect(Collectors.toSet()))
                .build();
    }
}
