package com.bestcode.pattern.summary.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 报社，被观察者
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class NewsOffice {

    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    /**
     * 新报纸来了
     */
    public void newspaperCome() {
        notifyAllObservers();
    }

    public void notifyAllObservers() {
        for (Customer customer: customers) {
            customer.update();
        }
    }
}
