package pl.portfolio.webapp.controllers.nailsalon;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;
import pl.portfolio.webapp.nailsalon.entities.dtos.ClientCredentialsDto;
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
        ClientCredentialsDto clientCredentialsDto = clientLoginService
                .findCredentialsByEmail(email);
        return ResponseEntity.ok().body(gson.toJson(clientCredentialsDto));
    }

    @GetMapping("/getClient")
    public ResponseEntity<String> getClientOfGivenId(@RequestParam(value="id") Long id) {
        ClientLoginEntity clientLoginEntity = clientLoginService.findConstantID(id).orElseThrow();
        return ResponseEntity.ok().body(gson.toJson(ClientToDtoMapper.MapEntityToDto(clientLoginEntity)));
    }
}
