package com.bestcode.spring.ioc.context;

import com.bestcode.spring.ioc.beans.factory.BeanFactory;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.31
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
