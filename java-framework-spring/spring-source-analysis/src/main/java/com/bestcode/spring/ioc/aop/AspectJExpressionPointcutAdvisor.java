package com.bestcode.spring.ioc.aop;

import org.aopalliance.aop.Advice;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.31
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;

    public Pointcut getPointcut() {
        return pointcut;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setExpression(String  expression) {
        this.pointcut.setExpression(expression);
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
