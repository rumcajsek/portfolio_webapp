package pl.portfolio.webapp.nailsalon.services;

import org.springframework.stereotype.Service;
import pl.portfolio.webapp.nailsalon.entities.ClientEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientToAddDto;
import pl.portfolio.webapp.nailsalon.repositories.ClientEntityRepository;

import java.util.List;

@Service
public class ClientService {
    ClientEntityRepository clientEntityRepository;

    public ClientService(ClientEntityRepository clientEntityRepository) {
        this.clientEntityRepository = clientEntityRepository;
    }

    public List<ClientEntity> getAllClientsList() {
        return clientEntityRepository.findAll();
    }

    public void addClientFullData(ClientToAddDto clientToAddDto) {
        ClientEntity clientEntity = new ClientEntity(
                clientToAddDto.getName(),
                clientToAddDto.getSurname()
        );

        ClientLoginEntity clientLoginEntity = new ClientLoginEntity(
                clientToAddDto.getEmail(),
                clientToAddDto.getPassword()
        );

    }
}
