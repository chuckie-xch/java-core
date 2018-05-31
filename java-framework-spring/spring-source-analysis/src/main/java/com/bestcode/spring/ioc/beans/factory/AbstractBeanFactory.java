package com.bestcode.spring.ioc.beans.factory;

import com.bestcode.spring.ioc.beans.BeanDefinition;
import com.bestcode.spring.ioc.beans.BeanPostProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.29
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    private final List<String> beanDefinitionNames = new ArrayList<String>();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    public Object getBean(String name) throws Exception {

        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("no bean named " + name + "is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
            bean = initializeBean(bean, name);
        }
        return bean;
    }

    protected Object initializeBean(Object bean, String name) throws Exception {
        for (BeanPostProcessor beanPostProcessor: beanPostProcessors) {
            bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
        }
        // todo : call initialize method
        for (BeanPostProcessor beanPostProcessor: beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
        }
        return bean;
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    public void preInstantiateSingletons() throws Exception {
        for (String beanName : beanDefinitionNames) {
            getBean(beanName);
        }
    }

    public List getBeansForType(Class type) throws Exception {
        List beans = new ArrayList<Object>();
        for (String beanDefinitionName : beanDefinitionNames) {
            if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
                beans.add(getBean(beanDefinitionName));
            }
        }
        return beans;
    }

    public void addBeanProstProcessor(BeanPostProcessor beanPostProcessor) throws Exception {
        this.beanPostProcessors.add(beanPostProcessor);
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
