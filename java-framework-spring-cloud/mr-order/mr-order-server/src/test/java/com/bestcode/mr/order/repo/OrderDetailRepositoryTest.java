package com.bestcode.mr.order.repo;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import javax.xml.transform.Result;

import com.bestcode.mr.order.OrderApplicationTests;
import com.bestcode.mr.order.model.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("111111");
        orderDetail.setOrderId("111111");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductIcon("http://www.xxx.com");
        orderDetail.setProductPrice(new BigDecimal(100));
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductQuantity(1);
        OrderDetail orderDetail1 = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(orderDetail != null);
    }
}