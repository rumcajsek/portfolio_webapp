package pl.portfolio.webapp.nailsalon.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientUserRole;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final ClientLoginService clientLoginService;

    public CustomUserDetailsService(ClientLoginService clientLoginService) {
        this.clientLoginService = clientLoginService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clientLoginService.findCredentialsByEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("no user found"));
    }

    private UserDetails createUserDetails(ClientLoginEntity credentials) {
        return User.builder()
                .username(credentials.getClientData().getName())
                .password(credentials.getPassword())
                .roles(credentials.getUserRoleSet().stream()
                        .map(ClientUserRole::getName)
                        .toArray(String[]::new))
                .build();
    }
}
