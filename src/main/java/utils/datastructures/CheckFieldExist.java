package utils.datastructures;

public class CheckFieldExist {
    public static boolean hasField(Object clazz, String fieldName) {
        // gather all fields of this class
        try {
            boolean flag = false;
            if (fieldName == null)
                return flag;
            flag = clazz.getClass().getSuperclass().getDeclaredField(fieldName) != null ;
            return flag;
        } catch (Exception e) {
            try {
                boolean flag = false;
                flag = clazz.getClass().getDeclaredField(fieldName) != null;
                return flag;
            } catch (Exception e2) {
                return false;
            }
        }
    }
}
