package com.bestcode.spring.ioc.aop;

import com.bestcode.spring.ioc.beans.BeanPostProcessor;
import com.bestcode.spring.ioc.beans.factory.AbstractBeanFactory;
import com.bestcode.spring.ioc.beans.factory.BeanFactory;
import com.bestcode.spring.ioc.context.BeanFactoryAware;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.List;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.31
 */
public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor, BeanFactoryAware {

    private AbstractBeanFactory beanFactory;


    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        if (bean instanceof AspectJExpressionPointcutAdvisor) {
            return bean;
        }
        if (bean instanceof MethodInterceptor) {
            return bean;
        }
        List<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansForType(AspectJExpressionPointcutAdvisor.class);
        for (AspectJExpressionPointcutAdvisor advisor: advisors) {
            if (advisor.getPointcut().getClassFilter().matches(bean.getClass())) {
                AdvisedSupport advisedSupport = new AdvisedSupport();
                advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
                TargetSource targetSource = new TargetSource(bean, bean.getClass().getInterfaces());
                advisedSupport.setTargetSource(targetSource);
                return new JdkDynamicAopProxy(advisedSupport).getProxy();
            }
        }
        return bean;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws Exception {
        this.beanFactory = (AbstractBeanFactory) beanFactory;
    }
}
