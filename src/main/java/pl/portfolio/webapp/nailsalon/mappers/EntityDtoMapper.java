package pl.portfolio.webapp.nailsalon.mappers;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * This mapper uses reflexion mechanism to generate mapper for every entity and it's DTO
 * But with only one condition, that DTO has the same fields with the same names as it's entity, minus the ID.
 */
public class EntityDtoMapper {

    /**
     *
     * @param entityClass - Entity Object
     * @param dtoClass - DTO Class
     * @param <T> matches entity object class
     * @param <U> matches dto object class
     * @return DTO Object
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException - all exceptions from reflextion mechanism
     */
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

    /**
     *
     * @param dtoClass DTO Object
     * @param entityClass Entity class
     * @return Entity object
     * @param <T> matches dto object class
     * @param <U> matches entity object class
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException all exceptions from the reflexion mechanism
     */
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
