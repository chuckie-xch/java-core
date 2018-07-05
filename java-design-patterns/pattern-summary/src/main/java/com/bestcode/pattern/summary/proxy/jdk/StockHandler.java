package com.bestcode.pattern.summary.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class StockHandler implements InvocationHandler {

    private Object target;

    private static Integer stock =  1;

    public StockHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (stock > 0) {
            method.invoke(target, null);
            stock --;
        } else {
            throw new RuntimeException("库存不足");
        }
        return null;
    }
}
