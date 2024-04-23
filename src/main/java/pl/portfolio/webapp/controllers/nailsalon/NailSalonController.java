package pl.portfolio.webapp.controllers.nailsalon;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.portfolio.webapp.nailsalon.entities.ClientEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientToAddDto;
import pl.portfolio.webapp.nailsalon.services.ClientService;

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
        model.addAttribute("clientToAdd", new ClientToAddDto());
        return "clients";
    }

    @PostMapping("/clients/add")
    public ResponseEntity<String> addUser(@RequestBody ClientToAddDto clientToAddDto) {
        try {
            clientService.addClientFullData(clientToAddDto);
            return ResponseEntity.ok("User added succesfully");
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
