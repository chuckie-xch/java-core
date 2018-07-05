package com.bestcode.pattern.summary.proxy.jdk;

import com.bestcode.pattern.summary.proxy.Station;
import com.bestcode.pattern.summary.proxy.TicketSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class TestJdkProxy {

    public static void main(String[] args) {
        Station station = new Station();
        InvocationHandler invocationHandler = new StockHandler(station);
        TicketSell ticketSell = (TicketSell) Proxy.newProxyInstance(Station.class.getClassLoader(), Station.class
                .getInterfaces(), invocationHandler);
        ticketSell.buyTicket();
        ticketSell.buyTicket();
    }
}
