package com.bestcode.javacore.asm;

import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.09.29
 */
public class SecurityCheckMethodAdaptor extends MethodAdapter {
    public SecurityCheckMethodAdaptor(MethodVisitor methodVisitor) {
        super(methodVisitor);
    }

    @Override
    public void visitCode() {
        visitMethodInsn(Opcodes.INVOKESTATIC,"SecurityChecker","checkSecurity","()V");
    }
}
