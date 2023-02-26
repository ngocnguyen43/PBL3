package utils.datastructures.searching;

import utils.datastructures.CheckFieldExist;
import utils.exceptions.dbExceptipns.NotFoundException;

import java.lang.reflect.Field;
import java.util.List;

public class InterpolationSearch<T> {
    private Object getFieldValue(Object object, String fieldName) {
        try {
            Field field = object.getClass().getSuperclass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            try {
                Field field = object.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                return field.get(object);
            } catch (NoSuchFieldException | IllegalAccessException e2) {
                return null;
            }
        }
    }

    public T Search(List<T> list, String field, Object value) throws NotFoundException {
        boolean isFieldExist = CheckFieldExist.hasField(list.get(0), field);
        if (!isFieldExist) throw new NotFoundException("Fields not exist in Object");
        Object data = getFieldValue(list.get(0), field);
        System.out.println(data);

        return list.get(0);
    }
}
