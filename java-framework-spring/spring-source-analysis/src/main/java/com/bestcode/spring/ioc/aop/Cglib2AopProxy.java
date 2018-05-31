package com.bestcode.spring.ioc.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.31
 */
public class Cglib2AopProxy extends AbstractAopProxy {


    public Cglib2AopProxy(AdvisedSupport advised) {
        super(advised);
    }

    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(advised.getTargetSource().getTargetClass());
        enhancer.setInterfaces(advised.getTargetSource().getInterfaces());
        enhancer.setCallback(new DynamicAdvisedInterceptor(advised));
        Object enhanced = enhancer.create();
        return enhanced;
    }

    private static class DynamicAdvisedInterceptor implements net.sf.cglib.proxy.MethodInterceptor {

        private AdvisedSupport advised;

        private MethodInterceptor delegateMethodInterceptor;

        private DynamicAdvisedInterceptor(AdvisedSupport advised) {
            this.advised = advised;
            delegateMethodInterceptor = advised.getMethodInterceptor();
        }

        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            if (advised.getMethodMatcher() == null || advised.getMethodMatcher().matches(method, advised
                    .getTargetSource().getTargetClass())) {
                return delegateMethodInterceptor.invoke(new CglibMethodInvocation(advised.getTargetSource().getTarget
                        (), method, args, proxy));
            }
            return new CglibMethodInvocation(advised.getTargetSource().getTarget(), method, args, proxy).proceed();
        }
    }

    private static class CglibMethodInvocation extends ReflectiveMethodInvocation {

        private final MethodProxy methodProxy;

        public CglibMethodInvocation(Object target, Method method, Object[] args, MethodProxy methodProxy) {
            super(target, method, args);
            this.methodProxy = methodProxy;
        }

        @Override
        public Object proceed() throws Throwable {
            return this.methodProxy.invoke(this.target, this.args);
        }
    }
}
