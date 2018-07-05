package com.bestcode.pattern.summary.proxy;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class TestStaticProxy {

    public static void main(String[] args) {
        Station station = new Station();
        TicketSell sell = new ProxyStation(station);
        sell.buyTicket();
        sell.buyTicket();
    }
}
