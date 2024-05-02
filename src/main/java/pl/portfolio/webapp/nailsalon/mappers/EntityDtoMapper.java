package pl.portfolio.webapp.nailsalon.mappers;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class EntityDtoMapper {
    public static <T, U> U mapEntityToDTO(T entityClass, Class<U> dtoClass)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        U dto = dtoClass.getDeclaredConstructor().newInstance();
        Field[] entityFields = entityClass.getClass().getDeclaredFields();
        Field[] dtoFields = dtoClass.getDeclaredFields();

        for(Field entityField : entityFields) {
            entityField.setAccessible(true);
            for(Field dtoField : dtoFields) {
                dtoField.setAccessible(true);
                if(entityField.getName().equals(dtoField.getName()) &&
                        !entityField.getName().equals("id")) {
                    dtoField.set(dto, entityField.get(entityClass));
                    break;
                }
            }
        }
        return dto;
    }

    public static <T, U> U mapDtoToEntity(T dtoClass, Class<U> entityClass)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        U entity = entityClass.getDeclaredConstructor().newInstance();
        Field[] entityFields = entityClass.getDeclaredFields();
        Field[] dtoFields = dtoClass.getClass().getDeclaredFields();

        for(Field dtoField : dtoFields) {
            dtoField.setAccessible(true);
            for(Field entityField : entityFields) {
                entityField.setAccessible(true);
                if(dtoField.getName().equals(entityField.getName())) {
                    entityField.set(entity, dtoField.get(dtoClass));
                    break;
                }
            }
        }
        return entity;
    }
}
