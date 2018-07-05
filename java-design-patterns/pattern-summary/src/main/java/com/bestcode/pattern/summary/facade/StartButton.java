package com.bestcode.pattern.summary.facade;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class StartButton {

    public void start() {
        new CPU().start();
        new Disk().start();
        new Memory().start();
    }
}
