package com.bestcode.spring.ioc.beans.factory;

import com.bestcode.spring.ioc.beans.BeanDefinition;
import com.bestcode.spring.ioc.beans.BeanReference;
import com.bestcode.spring.ioc.beans.PropertyValue;
import com.bestcode.spring.ioc.beans.PropertyValues;

import java.lang.reflect.Field;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.29
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {


    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValueList()) {
            Field field = beanDefinition.getBeanClass().getDeclaredField(propertyValue.getName());
            field.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            field.set(bean,value);
        }
    }

    private Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }
}
