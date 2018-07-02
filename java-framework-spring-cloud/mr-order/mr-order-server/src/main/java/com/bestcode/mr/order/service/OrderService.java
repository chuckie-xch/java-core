package com.bestcode.mr.order.service;

import com.bestcode.mr.order.model.dto.OrderDTO;

/**
 * 订单服务
 *
 * @author xch
 * @create 2018-06-08 0:00
 **/
public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);

    OrderDTO finish(String orderId);
}
