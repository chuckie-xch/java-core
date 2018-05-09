package com.bestcode.javacore.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.08
 */
public class ProxyDemo {

    public static void main(String[] args) {
        ProxyDemo proxyDemo = new ProxyDemo();
        Subject subject = proxyDemo.new RealSubject();
        DynamicProxy dynamicProxy = proxyDemo.new DynamicProxy(subject);
        Subject subjectProxy = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),dynamicProxy);
        subjectProxy.sayHello();
    }

    interface Subject {
        void sayHello();
    }

    class RealSubject implements Subject{

        public void sayHello() {
            System.out.println("RealSubject say hello");
        }
    }

    class DynamicProxy implements InvocationHandler {

        private Object subject;

        public DynamicProxy(Object subject) {
            this.subject = subject;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before");
            method.invoke(subject,args);
            System.out.println("after");
            return null;
        }
    }
}
