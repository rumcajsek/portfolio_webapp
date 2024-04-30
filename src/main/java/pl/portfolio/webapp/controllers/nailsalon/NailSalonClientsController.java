package pl.portfolio.webapp.controllers.nailsalon;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.portfolio.webapp.nailsalon.entities.ClientToAddDto;
import pl.portfolio.webapp.nailsalon.services.ClientService;

@Controller
@RequestMapping("/projects/nailSalon/clients")
public class NailSalonClientsController {

    private final ClientService clientService;

    public NailSalonClientsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clientsAddClient")
    public String getNailSalonAddClientPage(Model model) {
        model.addAttribute("clientToAdd", new ClientToAddDto());
        return "clientsAddClient";
    }

    @PostMapping(value = "/clientsAddClient/addClient")
    public ResponseEntity<?> addUser(@ModelAttribute ClientToAddDto clientToAddDto) {
        try {
            clientService.addClientFullData(clientToAddDto);
            return new ResponseEntity<>(clientToAddDto, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add user: " + e.getMessage());
        }
    }

}
