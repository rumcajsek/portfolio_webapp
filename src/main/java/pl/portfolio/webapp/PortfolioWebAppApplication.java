package pl.portfolio.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.portfolio.webapp.nailsalon.entities.dtos.AppointmentDto;
import pl.portfolio.webapp.nailsalon.entities.AppointmentEntity;
import pl.portfolio.webapp.nailsalon.mappers.EntityDtoMapper;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;

@SpringBootApplication
public class PortfolioWebAppApplication {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        SpringApplication.run(PortfolioWebAppApplication.class, args);
        AppointmentEntity appointmentEntity = new AppointmentEntity(1L, "test", LocalDateTime.now());
        AppointmentEntity appointmentEntity1 = new AppointmentEntity();
        AppointmentDto appointmentDto = new AppointmentDto();
        AppointmentDto appointmentDto1 = new AppointmentDto("dtoTest", LocalDateTime.of(2024, 5,6,12,0,0));
        System.out.println(appointmentEntity);
        System.out.println(appointmentDto1);
        appointmentEntity1 = EntityDtoMapper.mapDtoToEntity(appointmentDto1, AppointmentEntity.class);
        appointmentDto = EntityDtoMapper.mapEntityToDTO(appointmentEntity, AppointmentDto.class);
        System.out.println(appointmentEntity1);
        System.out.println(appointmentDto);

    }

}
