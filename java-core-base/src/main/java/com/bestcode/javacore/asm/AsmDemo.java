package com.bestcode.javacore.asm;

import org.junit.Test;
import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import sun.misc.Unsafe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.ProtectionDomain;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.29
 */
public class AsmDemo {


    @Test
    public void testGeneratorClass() throws Exception {
        ClassReader cr = new ClassReader("com.bestcode.javacore.asm.Account");
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        SecurityCheckClassAdaptor checkClassAdaptor = new SecurityCheckClassAdaptor(cw);
        cr.accept(checkClassAdaptor, ClassReader.SKIP_DEBUG);
        byte[] data = cw.toByteArray();

        Class accountClass = getUnsafe().defineClass("Account", data, 0, data.length, Account.class
                .getClassLoader(), Account.class.getProtectionDomain());
        Account account = (Account) accountClass.newInstance();
        account.operation();
//        File file = new File("Account.class");
//        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
//            fileOutputStream.write(data);
//        }
//        Account account = new Account();
//        account.operation();;
    }

    public static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        return unsafe;
    }

}
