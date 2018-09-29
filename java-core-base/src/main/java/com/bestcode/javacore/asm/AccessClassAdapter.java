package com.bestcode.javacore.asm;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.29
 */
public class AccessClassAdapter extends ClassAdapter {
    public AccessClassAdapter(ClassVisitor classVisitor) {
        super(classVisitor);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        int privateAccess = Opcodes.ACC_PRIVATE;
        return super.visitField(privateAccess, name, desc, signature, value);
    }
}
