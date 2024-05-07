package pl.portfolio.webapp.nailsalon.services;

import org.springframework.stereotype.Service;
import pl.portfolio.webapp.nailsalon.entities.dtos.ClientLoginEntityDto;

import java.util.Optional;

@Service
public class ClientLoginService {
    public Optional<ClientLoginEntityDto> findCredentialsByEmail(String email) {
        return Optional.empty();
    }
}
