package com.bestcode.spring.ioc.beans.factory;

import com.bestcode.spring.ioc.beans.BeanDefinition;

/**
 * bean 工厂
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.29
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

}
