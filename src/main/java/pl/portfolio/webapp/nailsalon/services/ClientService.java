package pl.portfolio.webapp.nailsalon.services;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.portfolio.webapp.nailsalon.entities.ClientEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;
import pl.portfolio.webapp.nailsalon.entities.dtos.ClientToAddDto;
import pl.portfolio.webapp.nailsalon.repositories.ClientEntityRepository;
import pl.portfolio.webapp.nailsalon.repositories.ClientLoginEntityRepository;

import java.util.List;

@Service
public class ClientService {
    private final ClientEntityRepository clientEntityRepository;
    private final ClientLoginEntityRepository clientLoginEntityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ClientService(ClientEntityRepository clientEntityRepository, ClientLoginEntityRepository clientLoginEntityRepository) {
        this.clientEntityRepository = clientEntityRepository;
        this.clientLoginEntityRepository = clientLoginEntityRepository;
    }

    public List<ClientEntity> getAllClientsList() {
        return clientEntityRepository.findAll();
    }

    @Transactional
    public void addClientFullData(@NotNull ClientToAddDto clientToAddDto) {
        ClientEntity clientEntity = new ClientEntity(
                clientToAddDto.getName(),
                clientToAddDto.getSurname()
        );

        ClientLoginEntity clientLoginEntity = new ClientLoginEntity(
                clientToAddDto.getEmail(),
                passwordEncoder.encode(clientToAddDto.getPassword())
        );

        clientEntity.setLoginData(clientLoginEntity);

        clientLoginEntityRepository.save(clientLoginEntity);
        clientEntityRepository.save(clientEntity);
    }

}
