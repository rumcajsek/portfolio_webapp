package pl.portfolio.webapp.nailsalon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client_login_data")
public class ClientLoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_to_user_role",
            joinColumns = @JoinColumn(table = "client_login_data", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(table = "client_user_role", referencedColumnName = "id")
    )
    private Set<ClientUserRole> userRoleSet = new HashSet<>();
}
