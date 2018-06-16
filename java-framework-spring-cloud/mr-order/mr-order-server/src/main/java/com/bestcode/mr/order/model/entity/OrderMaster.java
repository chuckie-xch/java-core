package com.bestcode.mr.order.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author xch
 * @create 2018-06-07 23:31
 **/
@Data
@Entity
public class OrderMaster {

    @Id
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;
    private Date createTime;
    private Date updateTime;

}
