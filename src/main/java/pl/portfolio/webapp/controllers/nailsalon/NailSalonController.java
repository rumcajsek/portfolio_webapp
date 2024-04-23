package pl.portfolio.webapp.controllers.nailsalon;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.portfolio.webapp.nailsalon.entities.ClientEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientToAddDto;
import pl.portfolio.webapp.nailsalon.services.ClientService;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/projects/nailSalon")
public class NailSalonController {
    private ClientService clientService;

    private List<ClientEntity> clientEntityList;

    public NailSalonController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/schedule")
    public String getNailSalonSchedulePage() {
        return "schedule";
    }

    @GetMapping("/clients")
    public String getNailSalonClientPage(Model model) {
        clientEntityList = clientService.getAllClientsList();
        model.addAttribute("clientList", clientEntityList);
        return "clients";
    }

    @GetMapping("/clients/clientsAddClient")
    public String getNailSalonAddClientPage(Model model) {
        model.addAttribute("clientToAdd", new ClientToAddDto());
        return "clientsAddClient";
    }

    @PostMapping(value = "/clients/clientsAddClient/addClient")
    public ResponseEntity<?> addUser(ClientToAddDto clientToAddDto) {
        try {
            clientService.addClientFullData(clientToAddDto);
            return new ResponseEntity<>(clientToAddDto, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add user: " + e.getMessage());
        }
    }

    @GetMapping("/prices")
    public String getNailSalonPricesPage() {
        return "prices";
    }

    @GetMapping("/services")
    public String getNailSalonServicesPage() {
        return "services";
    }

    @GetMapping("/about")
    public String getNailSalonAboutPage() {
        return "about";
    }

    @GetMapping("/gallery")
    public String getNailSalonGalleryPage() {
        return "gallery";
    }

    @GetMapping("/someRequest")
    public String getSomePage() {
        return "dummyPage";
    }
}
