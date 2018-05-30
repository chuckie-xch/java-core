package com.bestcode.spring.ioc.beans;

/**
 * bean配置元数据解析
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.29
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
