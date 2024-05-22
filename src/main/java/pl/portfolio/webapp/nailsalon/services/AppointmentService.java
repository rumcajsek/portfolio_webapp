package pl.portfolio.webapp.nailsalon.services;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.portfolio.webapp.nailsalon.entities.AppointmentEntity;
import pl.portfolio.webapp.nailsalon.entities.ClientEntity;
import pl.portfolio.webapp.nailsalon.entities.ServicesEntity;
import pl.portfolio.webapp.nailsalon.entities.dtos.AppointmentDto;
import pl.portfolio.webapp.nailsalon.repositories.AppointmentEntityRepository;
import pl.portfolio.webapp.nailsalon.repositories.ClientEntityRepository;
import pl.portfolio.webapp.nailsalon.repositories.ServicesEntityRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AppointmentService {
    private final AppointmentEntityRepository appointmentEntityRepository;
    private final ClientEntityRepository clientEntityRepository;
    private final ServicesEntityRepository servicesEntityRepository;

    public AppointmentService(AppointmentEntityRepository appointmentEntityRepository, ClientEntityRepository clientEntityRepository, ServicesEntityRepository servicesEntityRepository) {
        this.appointmentEntityRepository = appointmentEntityRepository;
        this.clientEntityRepository = clientEntityRepository;
        this.servicesEntityRepository = servicesEntityRepository;
    }

    @Transactional
    public Long saveAppointment(AppointmentDto appointmentDto) {
        ClientEntity clientEntity = clientEntityRepository.findByNameAndSurname(appointmentDto.getClientEntityDto().getName(),
                appointmentDto.getClientEntityDto().getSurname())
                .orElseThrow();
        ServicesEntity servicesEntity = servicesEntityRepository.findByName(appointmentDto.getServicesDto().getName())
                .orElseThrow();
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setClientEntity(clientEntity);
        appointmentEntity.setServicesEntity(servicesEntity);
        appointmentEntity.setDate(appointmentDto.getDate());
        return appointmentEntityRepository.save(appointmentEntity).getId();
    }

    public List<AppointmentEntity> getAppointmentList() {
        return appointmentEntityRepository.findAll(Sort.by(Sort.Direction.ASC, "date"));
    }

    public List<List<LocalDateTime>> getCurrentMonthCalendar() {
        LocalDateTime currentDate = LocalDateTime.now(ZoneId.systemDefault());
        return getCalendarForGivenMonth(currentDate);
    }

    public List<List<LocalDateTime>> getCalendarForGivenMonth(LocalDateTime givenDate) {
        List<List<LocalDateTime>> calendar = new ArrayList<>();
        populateCalendar(givenDate, calendar);
        return calendar;
    }

    private void populateCalendar(LocalDateTime date, List<List<LocalDateTime>> calendar) {
        LocalDateTime firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());
        int startDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();
        int numDaysInMonth = lastDayOfMonth.getDayOfMonth();

        List<LocalDateTime> week = new ArrayList<>();

        // Add empty cells for days before the first day of the month
        for (int i = 1; i < startDayOfWeek; i++) {
            week.add(null);
        }
        // Add days of the month to the calendar grid
        for (int dayOfMonth = 1; dayOfMonth <= numDaysInMonth; dayOfMonth++) {
            week.add(LocalDateTime.of(date.getYear(), date.getMonth(), dayOfMonth, 0,0));
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
    }

}
