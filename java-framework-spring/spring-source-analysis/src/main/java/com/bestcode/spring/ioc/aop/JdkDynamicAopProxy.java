package com.bestcode.spring.ioc.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.30
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    private AdvisedSupport advised;

    public JdkDynamicAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), advised.getTargetSource()
                .getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = advised.getMethodInterceptor();

        return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method,
                args));
    }
}
