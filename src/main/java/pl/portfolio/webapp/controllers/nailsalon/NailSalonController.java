package pl.portfolio.webapp.controllers.nailsalon;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.portfolio.webapp.nailsalon.entities.ClientEntity;
import pl.portfolio.webapp.nailsalon.services.ClientService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.rmi.server.LogStream.log;

@Slf4j
@Controller
@RequestMapping("/projects/nailSalon")
public class NailSalonController {
    private ClientService clientService;

    private List<ClientEntity> clientEntityList;

    public NailSalonController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/schedule")
    public String getNailSalonSchedulePage(Model model) {
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment("Some Job", LocalDateTime.of(2024,6,22,14,15)));
        appointments.add(new Appointment("Other Task", LocalDateTime.of(2024,6,22,16,15)));
        appointments.add(new Appointment("Even Longer Task", LocalDateTime.of(2024,6,22,18,15)));
        appointments.add(new Appointment("Presentation", LocalDateTime.of(2024, 6, 25, 14, 0)));
        appointments.add(new Appointment("Training", LocalDateTime.of(2024, 6, 28, 10, 30)));

        LocalDateTime currentDate = LocalDateTime.now();

        currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
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

        List<List<LocalDateTime>> calendar = new ArrayList<>();
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

        model.addAttribute("calendar", calendar);
        model.addAttribute("title", "My Calendar - " + currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        model.addAttribute("appointments", appointments);
        return "schedule";
    }

    @GetMapping("/clients")
    public String getNailSalonClientPage(Model model) {
        clientEntityList = clientService.getAllClientsList();
        model.addAttribute("clientList", clientEntityList);
        return "clients";
    }

    @GetMapping("/prices")
    public String getNailSalonPricesPage(Model model) {
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment("Masniczka", LocalDateTime.of(2024,6,22,14,15)));
        appointments.add(new Appointment("Kasia", LocalDateTime.of(2024,6,22,16,15)));
        appointments.add(new Appointment("Asia", LocalDateTime.of(2024,6,22,18,15)));
        appointments.add(new Appointment("Presentation", LocalDateTime.of(2024, 6, 25, 14, 0)));
        appointments.add(new Appointment("Training", LocalDateTime.of(2024, 6, 28, 10, 30)));

        LocalDateTime currentDate = LocalDateTime.now();

        currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
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

        List<List<LocalDateTime>> calendar = new ArrayList<>();
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

        model.addAttribute("calendar", calendar);
        model.addAttribute("title", "My Calendar - " + currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        model.addAttribute("appointments", appointments);
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

    @Getter
    public static class Appointment {
        private final String title;
        private final LocalDateTime date;

        public Appointment(String title, LocalDateTime date) {
            this.title = title;
            this.date = date;
        }

    }
}
