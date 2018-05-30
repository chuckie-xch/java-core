package com.bestcode.spring.ioc.context;

import com.bestcode.spring.ioc.beans.BeanDefinition;
import com.bestcode.spring.ioc.beans.factory.AbstractBeanFactory;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.30
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {

    }

    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }

}
