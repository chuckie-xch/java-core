package com.bestcode.mr.order.service.impl;

import java.math.BigDecimal;

import com.bestcode.mr.order.enums.OrderStatusEnum;
import com.bestcode.mr.order.enums.PayStatusEnum;
import com.bestcode.mr.order.model.dto.OrderDTO;
import com.bestcode.mr.order.model.entity.OrderMaster;
import com.bestcode.mr.order.repo.OrderDetailRepository;
import com.bestcode.mr.order.repo.OrderMasterRepository;
import com.bestcode.mr.order.service.OrderService;
import com.bestcode.mr.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xch
 * @create 2018-06-08 0:00
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    public OrderDTO create(OrderDTO orderDTO) {

        // TODO 查询商品信息
        // TODO 计算总价
        // TODO 扣库存
        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.uuid());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(200));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
