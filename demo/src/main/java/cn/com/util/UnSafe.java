package cn.com.util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author dubooooo@126.com 2018-04-03
 */
public class UnSafe {

    private static sun.misc.Unsafe unsafe;

    public static sun.misc.Unsafe getUnsafe() {
        if (unsafe == null) {
            try {
                Field field = Unsafe.class.getDeclaredField("theUnsafe");
                field.setAccessible(true);
                unsafe = (Unsafe) field.get(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return unsafe;
    }

}
