package com.bestcode.source.dubbo.rpc.proxy;

import com.bestcode.source.dubbo.rpc.Invoker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.09
 */
public class InvokerInvocationHandler implements InvocationHandler{

    /**
     * MockClusterInvoker
     */
    private final Invoker<?> invoker;

    public InvokerInvocationHandler(Invoker<?> invoker) {
        this.invoker = invoker;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class == method.getDeclaringClass()) {
            method.invoke(invoker,args);
        }


        return null;
    }
}
