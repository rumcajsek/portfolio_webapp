package pl.portfolio.webapp.nailsalon.services;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.portfolio.webapp.nailsalon.entities.ClientEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;
import pl.portfolio.webapp.nailsalon.entities.dtos.ClientToAddDto;
import pl.portfolio.webapp.nailsalon.exceptions.NoUserRoleFoundException;
import pl.portfolio.webapp.nailsalon.repositories.ClientEntityRepository;
import pl.portfolio.webapp.nailsalon.repositories.ClientLoginEntityRepository;
import pl.portfolio.webapp.nailsalon.repositories.ClientUserRoleRepository;

import java.util.List;
import java.util.Set;

@Service
public class ClientService {
    private final ClientEntityRepository clientEntityRepository;
    private final ClientLoginEntityRepository clientLoginEntityRepository;
    private final ClientUserRoleRepository clientUserRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ClientService(ClientEntityRepository clientEntityRepository, ClientLoginEntityRepository clientLoginEntityRepository, ClientUserRoleRepository clientUserRoleRepository) {
        this.clientEntityRepository = clientEntityRepository;
        this.clientLoginEntityRepository = clientLoginEntityRepository;
        this.clientUserRoleRepository = clientUserRoleRepository;
    }

    public List<ClientLoginEntity> getAllClientsList() {
        return clientLoginEntityRepository.findAll();
    }

    public ClientLoginEntity getClientById(Long id) {
        return clientLoginEntityRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Long addClientFullData(@NotNull ClientToAddDto clientToAddDto) {
        ClientEntity clientEntity = new ClientEntity(
                clientToAddDto.getName(),
                clientToAddDto.getSurname()
        );

        ClientLoginEntity clientLoginEntity = new ClientLoginEntity(
                clientToAddDto.getEmail(),
                passwordEncoder.encode(clientToAddDto.getPassword())
        );
        clientLoginEntity.setUserRoleSet(Set.of(clientUserRoleRepository.findByName("USER").orElseThrow(NoUserRoleFoundException::new)));
        clientLoginEntity.setClientData(clientEntity);

        Long savedClientId = clientLoginEntityRepository.save(clientLoginEntity).getId();
        clientEntityRepository.save(clientEntity);
        return savedClientId;
    }

}
