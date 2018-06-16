package com.bestcode.mr.order.converter;

import java.util.ArrayList;
import java.util.List;

import com.bestcode.mr.order.model.dto.OrderDTO;
import com.bestcode.mr.order.model.entity.OrderDetail;
import com.bestcode.mr.order.model.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xch
 * @create 2018-06-08 23:07
 **/
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
        try {
            orderDetails = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e){
            log.error("【json转换】错误，string={}", orderForm.getItems());
        }
        orderDTO.setOrderDetailList(orderDetails);
        return orderDTO;
    }
}
