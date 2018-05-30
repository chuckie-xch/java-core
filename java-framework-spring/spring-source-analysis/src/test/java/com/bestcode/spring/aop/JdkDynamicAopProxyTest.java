package com.bestcode.spring.aop;

import com.bestcode.spring.ioc.UserService;
import com.bestcode.spring.ioc.aop.AdvisedSupport;
import com.bestcode.spring.ioc.aop.JdkDynamicAopProxy;
import com.bestcode.spring.ioc.aop.TargetSource;
import com.bestcode.spring.ioc.context.ApplicationContext;
import com.bestcode.spring.ioc.context.ClassPathXmlApplicationContext;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.30
 */
public class JdkDynamicAopProxyTest {

    @Test
    public void testInterceptor() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.helloWorld();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(UserService.class, userService);
        advisedSupport.setTargetSource(targetSource);
        MethodInterceptor timeInterceptor = new TimeInterceptor();
        advisedSupport.setMethodInterceptor(timeInterceptor);

        // 创建代理
        JdkDynamicAopProxy proxy = new JdkDynamicAopProxy(advisedSupport);
        UserService userServiceProxy = (UserService) proxy.getProxy();
        userServiceProxy.helloWorld();

    }
}
