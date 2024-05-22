package pl.portfolio.webapp.controllers.nailsalon;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.portfolio.webapp.nailsalon.entities.dtos.ClientToAddDto;
import pl.portfolio.webapp.nailsalon.services.ClientService;

import java.net.URI;

@Controller
@RequestMapping("/projects/nailSalon/clients")
public class NailSalonClientsController {

    private final ClientService clientService;

    public NailSalonClientsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/addClient")
    public ResponseEntity<?> addUser(@ModelAttribute ClientToAddDto clientToAddDto) {
        Long id;
        try {
            id = clientService.addClientFullData(clientToAddDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add user: " + e.getMessage());
        }
        return ResponseEntity.created(URI.create("/projects/nailSalon/clients/" + id)).build();
    }

}
