package pl.portfolio.webapp.nailsalon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="client_user_role")
public class ClientUserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(targetEntity = ClientLoginEntity.class,
            mappedBy = "userRoleSet",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<ClientLoginEntity> clientEntitySet;

    public ClientUserRole(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ClientUserRole(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
