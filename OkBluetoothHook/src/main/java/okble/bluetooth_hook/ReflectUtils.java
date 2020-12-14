package okble.bluetooth_hook;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author: okbean
 * date:   On 2020/10/01
 * email: okbean020@163.com
 * description:反射操作工具类
 */
public final class ReflectUtils {

    public static Class<?> getClass(final String className) throws ClassNotFoundException {
        final Class<?> val = Class.forName(className);
        return val;
    }

    public static Object getFieldValue(final Object obj,final String className, final String fieldName) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        final Class<?> clazz = getClass(className);
        final Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        final Object val = field.get(obj);
        return val;
    }

    public static Field getField(final Class<?> clazz, final String fieldName) throws NoSuchFieldException {
        final Field val = clazz.getDeclaredField(fieldName);
        return val;
    }


    public static Field getField(final String className, final String fieldName) throws NoSuchFieldException, ClassNotFoundException {
        final Class<?> clazz = getClass(className);
        final Field val = getField(clazz, fieldName);
        return val;
    }


    public static Method getMethod(final Class<?> clazz, final String methodName, final Class<?>... parameterTypes) throws NoSuchMethodException {
        final Method val = clazz.getDeclaredMethod(methodName,parameterTypes);
        return val;
    }



    public static Method getMethod(final String className, final String methodName, final Class<?>... parameterTypes) throws NoSuchMethodException, ClassNotFoundException {
        final Class<?> clazz = getClass(className);
        final Method val = getMethod(clazz, methodName, parameterTypes);
        return val;
    }



    public static Object invokeMethod(final Object obj, final String className,final String methodName, final Class<?>[] parameterTypes, final Object... args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        final Method method = getMethod(className, methodName, parameterTypes);
        final Object val = method.invoke(obj, args);
        return val;
    }


    private ReflectUtils(){}
}
