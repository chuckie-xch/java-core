package com.bestcode.pattern.summary.observer;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class TestObserver {

    public static void main(String[] args) {
        NewsOffice newsOffice = new NewsOffice();
        newsOffice.addCustomer(new CustomerA());
        newsOffice.addCustomer(new CustomerB());
        newsOffice.newspaperCome();
    }
}
