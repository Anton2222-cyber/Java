package dz;


import java.lang.reflect.Field;


public class ObjectCopier {
    public static <T> T copyObject(T original) {
        try {
            return cloneObject(original);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T cloneObject(T original) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = original.getClass();
        T copy = (T) clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(original);
            if (value != null && !field.getType().isPrimitive() && !field.getType().equals(String.class) && !field.getType().getPackage().getName().startsWith("java")) {
                field.set(copy, copyObject(value));
            } else {
                field.set(copy, value);
            }
        }

        return copy;
    }
}
