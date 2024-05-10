package pl.portfolio.webapp.nailsalon.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;
import pl.portfolio.webapp.nailsalon.entities.dtos.ClientLoginEntityDto;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final ClientLoginService clientLoginService;

    public CustomUserDetailsService(ClientLoginService userService) {
        this.clientLoginService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clientLoginService.findCredentialsByEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", username)));
    }

    private UserDetails createUserDetails(ClientLoginEntity credentials) {
        return User.builder()
                .username(credentials.getClientData().getName())
                .password(credentials.getPassword())
                .roles(credentials.getUserRoleSet().toArray(String[]::new))
                .build();
    }
}
