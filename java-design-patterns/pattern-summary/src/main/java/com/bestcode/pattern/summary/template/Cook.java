package com.bestcode.pattern.summary.template;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public abstract class Cook {

    public void open() {
        System.out.println("打开油烟机");
    }

    public void fire() {
        System.out.println("生火");
    }

    public abstract void doCook();

    public void outfire() {
        System.out.println("灭火");
    }

    public void close() {
        System.out.println("关闭油烟机");
    }

    public final void cook() {
        open();
        fire();
        doCook();
        outfire();
        close();
    }
}
