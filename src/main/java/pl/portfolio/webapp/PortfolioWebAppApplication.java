package pl.portfolio.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import pl.portfolio.webapp.nailsalon.entities.AppointmentEntity;
import pl.portfolio.webapp.nailsalon.repositories.AppointmentEntityRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "pl.portfolio.webapp")
public class PortfolioWebAppApplication {

    public final AppointmentEntityRepository appointmentEntityRepository;

    public PortfolioWebAppApplication(AppointmentEntityRepository appointmentEntityRepository) {
        this.appointmentEntityRepository = appointmentEntityRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(PortfolioWebAppApplication.class, args);
//        List<AppointmentEntity> appointmentEntityList = new ArrayList<>();
//        appointmentEntityList.add(new AppointmentEntity("Masniczka", LocalDateTime.of(2024,6,22,14,15)));
//        appointmentEntityList.add(new AppointmentEntity("Kasia", LocalDateTime.of(2024,6,22,16,15)));
//        appointmentEntityList.add(new AppointmentEntity("Asia", LocalDateTime.of(2024,6,22,18,15)));
//        appointmentEntityList.add(new AppointmentEntity("Presentation", LocalDateTime.of(2024, 6, 25, 14, 0)));
//        appointmentEntityList.add(new AppointmentEntity("Training", LocalDateTime.of(2024, 6, 28, 10, 30)));
    }

    @Bean
    CommandLineRunner runner(List<AppointmentEntity> list) {
        return args -> {
            appointmentEntityRepository.save(new AppointmentEntity("Masniczka", LocalDateTime.of(2024,6,22,14,15)));
            appointmentEntityRepository.save(new AppointmentEntity("Kasia", LocalDateTime.of(2024,6,22,16,15)));
            appointmentEntityRepository.save(new AppointmentEntity("Asia", LocalDateTime.of(2024,6,22,18,15)));
            appointmentEntityRepository.save(new AppointmentEntity("Presentation", LocalDateTime.of(2024, 6, 25, 14, 0)));
            appointmentEntityRepository.save(new AppointmentEntity("Training", LocalDateTime.of(2024, 6, 28, 10, 30)));

        };
    }

}
