package pl.portfolio.webapp.controllers.nailsalon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.portfolio.webapp.nailsalon.entities.AppointmentEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;
import pl.portfolio.webapp.nailsalon.entities.dtos.ClientToAddDto;
import pl.portfolio.webapp.nailsalon.entities.dtos.ServicesDto;
import pl.portfolio.webapp.nailsalon.services.AppointmentService;
import pl.portfolio.webapp.nailsalon.services.ClientService;
import pl.portfolio.webapp.nailsalon.services.ServicesService;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@Controller
@RequestMapping("/projects/nailSalon")
public class NailSalonController {
    private final ClientService clientService;
    private final AppointmentService appointmentService;
    private final ServicesService servicesService;

    public NailSalonController(ClientService clientService, AppointmentService appointmentService, ServicesService servicesService) {
        this.clientService = clientService;
        this.appointmentService = appointmentService;
        this.servicesService = servicesService;
    }

    @RequestMapping("/logout")
    public String performLogout() {
        return "redirect:/projects/nailSalon";
    }

    @GetMapping("/schedule")
    public String getNailSalonSchedulePage(Model model) {
        //List<AppointmentEntity> appointmentEntities = appointmentService.getAppointmentList();
        List<Appointment> appointmentEntities = new ArrayList<>();

        appointmentEntities.add(new Appointment(1L, "Masniczka", LocalDateTime.of(2024,6,22,14,15)));
        appointmentEntities.add(new Appointment(2L, "Szkolenie podologiczne", LocalDateTime.of(2024,6,19,9,15)));
        appointmentEntities.add(new Appointment(3L, "Kasia", LocalDateTime.of(2024,6,22,16,15)));
        appointmentEntities.add(new Appointment(4L, "Asia", LocalDateTime.of(2024,6,22,18,15)));
        appointmentEntities.add(new Appointment(5L, "Basia", LocalDateTime.of(2024, 6, 25, 14, 0)));
        appointmentEntities.add(new Appointment(6L, "SZKOLENIE PEDI", LocalDateTime.of(2024, 6, 28, 10, 30)));
        LocalDateTime currentDate = LocalDateTime.now();
        currentDate = currentDate.plusMonths(1);
        //List<List<LocalDateTime>> calendar = appointmentService.getCurrentMonthCalendar();
        List<List<LocalDateTime>> calendar = appointmentService.getCalendarForGivenMonth(currentDate); // TODO: Remove, only for testing purpose, uncomment line above.


        model.addAttribute("calendar", calendar);
        model.addAttribute("title", "My Calendar - " + currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        model.addAttribute("appointments", appointmentEntities);
        return "schedule";
    }

    @GetMapping("/clients")
    public String getNailSalonClientPage(Model model) {
        List<ClientLoginEntity> clientEntityList = clientService.getAllClientsList();
        model.addAttribute("clientToAdd", new ClientToAddDto());
        model.addAttribute("clientList", clientEntityList);
        return "clients";
    }

    @GetMapping("/services")
    public String getNailSalonServicesPage(Model model) {
        List<ServicesDto> servicesList = servicesService.findAllServices();
        model.addAttribute("serviceToAdd", new ServicesDto());
        model.addAttribute("servicesList", servicesList);
        return "services";
    }

    @PostMapping("/services/addService")
    public ResponseEntity<?> addNewService(@ModelAttribute ServicesDto serviceToAdd) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Long id;
        try {
            id = servicesService.saveService(serviceToAdd);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to create service: " + e.getMessage());
        }
        return ResponseEntity.created(URI.create("/projects/nailSalon/services/" + id)).build();
    }

    @GetMapping("/about")
    public String getNailSalonAboutPage() {
        return "about";
    }

    @GetMapping("/gallery")
    public String getNailSalonGalleryPage() {
        return "gallery";
    }

    @GetMapping("/contact")
    public String getNailSalonContactPage() {
        return "contact";
    }

    @GetMapping("/someRequest")
    public String getSomePage() {
        return "dummyPage";
    }

    @Data
    @AllArgsConstructor
    public static class Appointment {
        private Long id;
        private String title;
        private LocalDateTime date;
    }
}
