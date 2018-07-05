package com.bestcode.pattern.summary.observer.jdk;

import java.util.Observable;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class NewsOffice2 extends Observable {

    public void newspaperCome() {
        this.setChanged();
        this.notifyObservers();
    }
}
