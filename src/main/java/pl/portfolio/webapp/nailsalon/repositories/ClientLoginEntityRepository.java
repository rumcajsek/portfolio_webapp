package pl.portfolio.webapp.nailsalon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;

import java.util.Optional;

public interface ClientLoginEntityRepository extends JpaRepository<ClientLoginEntity, Long> {
        //String GET_USER_ALL_DATA = "SELECT cli.*, cld.*, cur.* FROM client_login_data cld  JOIN clients cli ON cli.id = cld.client_data_id JOIN client_to_user_role ctur ON ctur.client_entity_set_id = cld.id JOIN client_user_role cur ON cur.id = ctur.user_role_set_id WHERE cld.email = :email";

        //@Query(GET_USER_ALL_DATA)
        Optional<ClientLoginEntity> findByEmailIgnoreCase(String email);
}
