package pl.portfolio.webapp.controllers.nailsalon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.portfolio.webapp.nailsalon.services.ClientService;

@Controller
@RequestMapping("/projects/nailSalon")
public class NailSalonController {
    private ClientService clientService;

    public NailSalonController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/schedule")
    public String getNailSalonSchedulePage() {
        return "schedule";
    }

    @GetMapping("/clients")
    public String getNailSalonClientPage() {
        return "clients";
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
}
