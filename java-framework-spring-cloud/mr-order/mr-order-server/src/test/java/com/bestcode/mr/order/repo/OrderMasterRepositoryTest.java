package com.bestcode.mr.order.repo;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import com.bestcode.mr.order.OrderApplicationTests;
import com.bestcode.mr.order.enums.OrderStatusEnum;
import com.bestcode.mr.order.enums.PayStatusEnum;
import com.bestcode.mr.order.model.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests{

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("111111");
        orderMaster.setBuyerName("张三丰");
        orderMaster.setBuyerAddress("武当");
        orderMaster.setBuyerOpenid("wxid11111");
        orderMaster.setBuyerPhone("110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result!=null);
    }
}