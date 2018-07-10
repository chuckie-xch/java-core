package com.bestcode.jpa.repository;

import com.bestcode.jpa.entity.Order;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.10
 */
public interface OrderRepository extends BaseRepository<Order, Long> {

    Order findByName(String name);
}
