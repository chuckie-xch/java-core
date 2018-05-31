package com.bestcode.spring.ioc;


import com.bestcode.spring.ioc.beans.BeanDefinition;

import com.bestcode.spring.ioc.beans.factory.AbstractBeanFactory;
import com.bestcode.spring.ioc.beans.factory.AutowireCapableBeanFactory;
import com.bestcode.spring.ioc.beans.io.ResourceLoader;
import com.bestcode.spring.ioc.beans.xml.XmlBeanDefinitionReader;
import com.bestcode.spring.ioc.context.ApplicationContext;
import com.bestcode.spring.ioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

import java.util.Map;

public class BeanFactoryTest {


    @Test
    public void testLazy() throws Exception {
       // 读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("bean.xml");

        // 初始化beanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry: xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
        beanFactory.preInstantiateSingletons();
        // 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.helloWorld();
    }

    @Test
    public void testApplicationContext() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        context.refresh();
        UserService userService = (UserService) context.getBean("userService");
        userService.helloWorld();
    }

}
