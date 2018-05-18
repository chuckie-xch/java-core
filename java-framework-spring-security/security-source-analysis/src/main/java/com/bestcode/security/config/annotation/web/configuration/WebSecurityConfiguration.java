package com.bestcode.security.config.annotation.web.configuration;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.17
 */
@Configuration
public class WebSecurityConfiguration implements ImportAware, BeanClassLoaderAware{

    public void setBeanClassLoader(ClassLoader classLoader) {

    }

    public void setImportMetadata(AnnotationMetadata importMetadata) {

    }
}
