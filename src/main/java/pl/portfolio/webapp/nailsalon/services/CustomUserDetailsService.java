package pl.portfolio.webapp.nailsalon.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientUserRole;
import pl.portfolio.webapp.nailsalon.entities.dtos.ClientCredentialsDto;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final ClientLoginService clientLoginService;

    public CustomUserDetailsService(ClientLoginService clientLoginService) {
        this.clientLoginService = clientLoginService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return createUserDetails(clientLoginService.findCredentialsByEmail(username));
    }

    private UserDetails createUserDetails(ClientCredentialsDto credentials) {
        return User.builder()
                .username(credentials.getName() + " " + credentials.getSurname())
                .password(credentials.getPassword())
                .roles(credentials.getUserRoles()
                        .toArray(String[]::new))
                .build();
    }
}
