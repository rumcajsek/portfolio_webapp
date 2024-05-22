package pl.portfolio.webapp.nailsalon.services;

import org.springframework.stereotype.Service;
import pl.portfolio.webapp.nailsalon.entities.ServicesEntity;
import pl.portfolio.webapp.nailsalon.entities.dtos.ServicesDto;
import pl.portfolio.webapp.nailsalon.mappers.EntityDtoMapper;
import pl.portfolio.webapp.nailsalon.repositories.ServicesEntityRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class ServicesService {
    private final ServicesEntityRepository servicesEntityRepository;

    public ServicesService(ServicesEntityRepository servicesEntityRepository) {
        this.servicesEntityRepository = servicesEntityRepository;
    }

    public List<ServicesDto> findAllServices() {
        return servicesEntityRepository.findAll().stream()
                .map(service -> {
                    try {
                        return EntityDtoMapper.mapEntityToDTO(service, ServicesDto.class);
                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException |
                             NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }

    public Long saveService(ServicesDto serviceToAdd) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        return servicesEntityRepository.save(EntityDtoMapper.mapDtoToEntity(serviceToAdd, ServicesEntity.class)).getId();
    }
}
