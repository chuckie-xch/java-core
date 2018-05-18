package com.bestcode.security.config.annotation.web.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * EnableWebSecurity
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.17
 */
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@Target(ElementType.TYPE)
@Import({WebSecurityConfiguration.class})
public @interface EnableWebSecurity {
}
