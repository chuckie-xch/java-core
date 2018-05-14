package com.bestcode.security.core.context;

import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Constructor;

/**
 * 存储安全信息的上下文，默认采用ThreadLocal策略
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.14
 */
public class SecurityContextHolder {

    public static final String MODE_THREADLOCAL = "MODE_THREADLOCAL";
    public static final String MODE_INHERITABLETHREADLOCAL = "MODE_INHERITABLETHREADLOCAL";
    public static final String MODE_GLOBAL = "MODE_GLOBAL";
    public static final String SYSTEM_PROPERTY = "spring.security.strategy";
    private static String strategyName = System.getProperty(SYSTEM_PROPERTY);
    private static SecurityContextHolderStrategy strategy;

    static {
        initialize();
    }

    private static void initialize() {
        if (!StringUtils.hasText(strategyName)) {
            strategyName = MODE_THREADLOCAL;
        }
        if (MODE_THREADLOCAL.equals(strategyName)) {
            strategy = new ThreadLocalSecurityContextHolderStrategy();
        } else if(MODE_INHERITABLETHREADLOCAL.equals(strategyName)) {
            strategy = new InheritableThreadLocalSecurityContextHolderStrategy();
        } else if (MODE_GLOBAL.equals(strategyName)) {
            // todo
        } else {
            try {
                Class<?> clazz = Class.forName(strategyName);
                Constructor<?> customStrategy = clazz.getConstructor();
               strategy = (SecurityContextHolderStrategy) customStrategy.newInstance();
            } catch (Exception e) {
                ReflectionUtils.handleReflectionException(e);
            }
        }
    }

    public static SecurityContext getContext() {
        return strategy.getContext();
    }
}
