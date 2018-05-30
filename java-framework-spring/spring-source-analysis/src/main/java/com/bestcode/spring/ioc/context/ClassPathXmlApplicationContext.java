package com.bestcode.spring.ioc.context;

import com.bestcode.spring.ioc.beans.BeanDefinition;
import com.bestcode.spring.ioc.beans.BeanDefinitionReader;
import com.bestcode.spring.ioc.beans.factory.AbstractBeanFactory;
import com.bestcode.spring.ioc.beans.factory.AutowireCapableBeanFactory;
import com.bestcode.spring.ioc.beans.io.ResourceLoader;
import com.bestcode.spring.ioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.30
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{


    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception{
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception{
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> entry: xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }
    }

}
