package com.bestcode.spring.ioc;


import com.bestcode.spring.ioc.factory.AutowireCapableBeanFactory;
import com.bestcode.spring.ioc.factory.BeanFactory;
import com.bestcode.spring.ioc.io.ResourceLoader;
import com.bestcode.spring.ioc.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

public class BeanFactoryTest {


    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("bean.xml");
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry: xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.helloWorld();
    }

}
