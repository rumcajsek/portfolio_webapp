package pl.portfolio.webapp.nailsalon.services;

import org.springframework.stereotype.Service;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;
import pl.portfolio.webapp.nailsalon.entities.dtos.ClientLoginEntityDto;
import pl.portfolio.webapp.nailsalon.repositories.ClientLoginEntityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientLoginService {
    public final ClientLoginEntityRepository clientLoginEntityRepository;

    public ClientLoginService(ClientLoginEntityRepository clientLoginEntityRepository) {
        this.clientLoginEntityRepository = clientLoginEntityRepository;
    }

    public Optional<ClientLoginEntity> findCredentialsByEmail(String email) {
        return clientLoginEntityRepository.findByEmailIgnoreCase(email);
    }
    
    public Optional<ClientLoginEntity> findConstantID() {
        return clientLoginEntityRepository.findById(1L);
    }
}