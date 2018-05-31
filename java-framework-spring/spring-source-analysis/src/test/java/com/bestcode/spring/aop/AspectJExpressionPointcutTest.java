package com.bestcode.spring.aop;

import com.bestcode.spring.ioc.UserService;
import com.bestcode.spring.ioc.aop.AspectJExpressionPointcut;
import org.junit.Test;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.31
 */
public class AspectJExpressionPointcutTest {

    @Test
    public void testClassFilter() {
        String expression = "execution(* com.bestcode.spring.ioc..*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(UserService.class);
        System.out.println(matches);
    }

}
