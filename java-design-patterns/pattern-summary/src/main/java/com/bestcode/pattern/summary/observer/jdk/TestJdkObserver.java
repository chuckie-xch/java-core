package com.bestcode.pattern.summary.observer.jdk;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class TestJdkObserver {

    public static void main(String[] args) {
        NewsOffice2 newsOffice2 = new NewsOffice2();
        newsOffice2.addObserver(new CostomerC());
        newsOffice2.newspaperCome();
    }
}
