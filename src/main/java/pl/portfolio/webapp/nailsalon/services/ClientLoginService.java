package pl.portfolio.webapp.nailsalon.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;
import pl.portfolio.webapp.nailsalon.entities.dtos.ClientCredentialsDto;
import pl.portfolio.webapp.nailsalon.mappers.ClientToDtoMapper;
import pl.portfolio.webapp.nailsalon.repositories.ClientLoginEntityRepository;

import java.util.Optional;

@Service
public class ClientLoginService {
    public final ClientLoginEntityRepository clientLoginEntityRepository;

    public ClientLoginService(ClientLoginEntityRepository clientLoginEntityRepository) {
        this.clientLoginEntityRepository = clientLoginEntityRepository;
    }

    public ClientCredentialsDto findCredentialsByEmail(String email) {
        return ClientToDtoMapper.MapCredentialsToDto(clientLoginEntityRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new UsernameNotFoundException("no user found")));
    }
    
    public Optional<ClientLoginEntity> findConstantID(Long id) {
        return clientLoginEntityRepository.findById(id);
    }
}