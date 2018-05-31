package com.bestcode.spring.ioc.aop;

/**
 * 被代理的对象
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.30
 */
public class TargetSource {

    private Class<?> targetClass;

    private Class<?>[] interfaces;

    private Object target;

    public TargetSource(Object target, Class<?> targetClass, Class<?>... interfaces) {
        this.targetClass = targetClass;
        this.target = target;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }
}
