package com.bestcode.pattern.summary.proxy;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class Station implements TicketSell {

    @Override
    public void buyTicket() {
        System.out.println("有人买了一张票");
    }
}
