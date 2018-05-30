package com.bestcode.spring.ioc.aop;

import org.aopalliance.aop.Advice;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.30
 */
public interface Advisor {

    Advice getAdvice();
}
