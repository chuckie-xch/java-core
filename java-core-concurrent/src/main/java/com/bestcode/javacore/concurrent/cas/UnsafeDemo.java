package com.bestcode.javacore.concurrent.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.28
 */
public class UnsafeDemo {

    private int value;

    public static void main(String[] args) throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        long valueOffset = unsafe.objectFieldOffset(UnsafeDemo.class.getDeclaredField("value"));
        System.out.println(valueOffset);
        UnsafeDemo unsafeDemo = new UnsafeDemo();
        unsafeDemo.setValue(10);
        boolean first = unsafe.compareAndSwapInt(unsafeDemo,valueOffset,10,11);
        System.out.println(first + ":" + unsafeDemo.getValue());
        boolean second = unsafe.compareAndSwapInt(unsafeDemo,valueOffset,10,12);
        System.out.println(second + ":" + unsafeDemo.getValue());
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
