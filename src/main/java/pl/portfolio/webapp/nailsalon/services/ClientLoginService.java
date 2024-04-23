package pl.portfolio.webapp.nailsalon.services;

import org.springframework.stereotype.Service;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginDataDto;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;

import java.util.Optional;

@Service
public class ClientLoginService {
    public Optional<ClientLoginDataDto> findCredentialsByEmail(String email) {
        return Optional.empty();
    }
}
