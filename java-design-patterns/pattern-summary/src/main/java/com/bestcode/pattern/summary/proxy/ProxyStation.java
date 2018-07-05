package com.bestcode.pattern.summary.proxy;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class ProxyStation implements TicketSell {

    private Station station;

    private static Integer stock = 1;

    public ProxyStation(Station station){
        this.station = station;
    }

    @Override
    public void buyTicket() {
        if (stock > 0) {
            station.buyTicket();
            stock--;
        } else {
            throw new RuntimeException("库存不足");
        }
    }
}
