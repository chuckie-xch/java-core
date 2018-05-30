package com.bestcode.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.30
 */
public class TimeInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        long beginTime = System.nanoTime();
        System.out.println("Invocation of Method: " + invocation.getMethod().getName() + "start!");
        Object object = invocation.proceed();
        System.out.println("Invocation of Method: " + invocation.getMethod().getName() + "end! takes " + (System.nanoTime() - beginTime));
        return object;
    }
}
