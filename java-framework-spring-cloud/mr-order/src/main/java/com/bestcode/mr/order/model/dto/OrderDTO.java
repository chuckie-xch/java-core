package com.bestcode.mr.order.model.dto;

import java.math.BigDecimal;
import java.util.List;

import com.bestcode.mr.order.model.entity.OrderDetail;
import lombok.Data;

/**
 * @author xch
 * @create 2018-06-08 0:02
 **/
@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
