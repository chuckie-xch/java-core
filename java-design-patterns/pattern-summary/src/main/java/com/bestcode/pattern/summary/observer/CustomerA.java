package com.bestcode.pattern.summary.observer;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class CustomerA implements Customer {
    @Override
    public void update() {
        System.out.println("我是客户A，我收到报纸啦");
    }
}
