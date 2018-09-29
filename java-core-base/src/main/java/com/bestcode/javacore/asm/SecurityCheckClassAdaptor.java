package com.bestcode.javacore.asm;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.29
 */
public class SecurityCheckClassAdaptor extends ClassAdapter {
    public SecurityCheckClassAdaptor(ClassVisitor classVisitor) {
        super(classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor methodVisitor = cv.visitMethod(access,name,desc,signature,exceptions);
        MethodVisitor wrappedMv = methodVisitor;
        if (wrappedMv != null) {
            if ("operation".equals(name)) {
                wrappedMv = new SecurityCheckMethodAdaptor(methodVisitor);
            }
        }
        return wrappedMv;
    }
}
