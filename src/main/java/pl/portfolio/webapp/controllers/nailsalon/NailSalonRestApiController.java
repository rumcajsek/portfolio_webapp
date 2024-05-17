package pl.portfolio.webapp.controllers.nailsalon;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;
import pl.portfolio.webapp.nailsalon.entities.dtos.FullClientDataDto;
import pl.portfolio.webapp.nailsalon.exceptions.NoUserWithGivenEmailFountException;
import pl.portfolio.webapp.nailsalon.mappers.ClientToDtoMapper;
import pl.portfolio.webapp.nailsalon.services.ClientLoginService;

@RestController
@RequestMapping(path = "/projects/nailSalon/api",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class NailSalonRestApiController {
    private final ClientLoginService clientLoginService;
    private final Gson gson;

    public NailSalonRestApiController(ClientLoginService clientLoginService) {
        this.clientLoginService = clientLoginService;
        this.gson = new Gson();
    }

    @GetMapping("/getClient/{email}")
    public ResponseEntity<String> getClientByEmail(@PathVariable String email) {
        ClientLoginEntity clientLoginEntity = clientLoginService
                .findCredentialsByEmail(email)
                .orElseThrow(() -> new NoUserWithGivenEmailFountException(email));
        FullClientDataDto fullClientDataDto = ClientToDtoMapper.MapEntityToDto(clientLoginEntity);
        return ResponseEntity.ok().body(gson.toJson(fullClientDataDto));
    }

    @GetMapping("/getClient")
    public ResponseEntity<String> getClientOfConstantID() {
        ClientLoginEntity clientLoginEntity = clientLoginService.findConstantID().orElseThrow();
        return ResponseEntity.ok().body(gson.toJson(ClientToDtoMapper.MapEntityToDto(clientLoginEntity)));
    }
}
