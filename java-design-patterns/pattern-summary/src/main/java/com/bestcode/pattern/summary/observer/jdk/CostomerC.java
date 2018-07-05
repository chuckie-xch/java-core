package com.bestcode.pattern.summary.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class CostomerC implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("我是客户C，我收到报纸啦");
    }
}
