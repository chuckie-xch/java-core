package com.bestcode.spring.ioc.beans.factory;

import com.bestcode.spring.ioc.beans.BeanDefinition;
import com.bestcode.spring.ioc.beans.BeanReference;
import com.bestcode.spring.ioc.beans.PropertyValue;
import com.bestcode.spring.ioc.beans.PropertyValues;
import com.bestcode.spring.ioc.context.BeanFactoryAware;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValueList()) {
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }

            try {
                Method declaredMethod = bean.getClass().getDeclaredMethod("set" + propertyValue.getName().substring(0, 1)
                        .toUpperCase() + propertyValue.getName().substring(1), value.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                Field field = beanDefinition.getBeanClass().getDeclaredField(propertyValue.getName());
                field.setAccessible(true);
                field.set(bean, value);
            }
        }
    }

    private Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }
}
