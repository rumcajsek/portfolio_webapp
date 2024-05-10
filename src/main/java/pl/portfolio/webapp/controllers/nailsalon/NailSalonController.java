package pl.portfolio.webapp.controllers.nailsalon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.portfolio.webapp.nailsalon.entities.AppointmentEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientLoginEntity;
import pl.portfolio.webapp.nailsalon.entities.dtos.ClientToAddDto;
import pl.portfolio.webapp.nailsalon.services.AppointmentService;
import pl.portfolio.webapp.nailsalon.services.ClientService;

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

    public NailSalonController(ClientService clientService, AppointmentService appointmentService) {
        this.clientService = clientService;
        this.appointmentService = appointmentService;
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

    @GetMapping("/prices")
    public String getNailSalonPricesPage(Model model) {
        List<AppointmentEntity> appointmentEntities = appointmentService.getAppointmentList();
        /*
        appointments.add(new Appointment("Masniczka", LocalDateTime.of(2024,6,22,14,15)));
        appointments.add(new Appointment("Kasia", LocalDateTime.of(2024,6,22,16,15)));
        appointments.add(new Appointment("Asia", LocalDateTime.of(2024,6,22,18,15)));
        appointments.add(new Appointment("Presentation", LocalDateTime.of(2024, 6, 25, 14, 0)));
        appointments.add(new Appointment("Training", LocalDateTime.of(2024, 6, 28, 10, 30)));
        */
        LocalDateTime currentDate = LocalDateTime.now();
        List<List<LocalDateTime>> calendar = appointmentService.getCurrentMonthCalendar();
        currentDate = currentDate.plusMonths(1);
        /*
        log.info(currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        currentDate = currentDate.plusMonths(2);
        LocalDateTime firstDayOfMonth = currentDate.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime lastDayOfMonth = currentDate.with(TemporalAdjusters.lastDayOfMonth());
        log.info("currentDate: {}", currentDate);
        log.info("firstDayOfMonth: {}", firstDayOfMonth);
        log.info("lastDayOfMonth: {}", lastDayOfMonth);
        int startDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();
        int numDaysInMonth = lastDayOfMonth.getDayOfMonth();
        log.info("startDayOfWeek: {}", startDayOfWeek);
        log.info("numDaysInMonth: {}", numDaysInMonth);
        */
        /*
        List<LocalDateTime> week = new ArrayList<>();
        // Add empty cells for days before the first day of the month
        for (int i = 1; i < startDayOfWeek; i++) {
            week.add(null);
        }
        // Add days of the month to the calendar grid
        for (int dayOfMonth = 1; dayOfMonth <= numDaysInMonth; dayOfMonth++) {
            week.add(LocalDateTime.of(currentDate.getYear(), currentDate.getMonth(), dayOfMonth, 0,0));
            if (week.size() == 7) {
                calendar.add(new ArrayList<>(week));
                week.clear();
            }
        }
        // Add empty cells for days after the last day of the month
        while (week.size() < 7) {
            week.add(null);
        }
        calendar.add(week);
        */

        model.addAttribute("calendar", calendar);
        model.addAttribute("title", "My Calendar - " + currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        model.addAttribute("appointments", appointmentEntities);
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

    @Data
    @AllArgsConstructor
    public static class Appointment {
        private Long id;
        private String title;
        private LocalDateTime date;
    }
}
