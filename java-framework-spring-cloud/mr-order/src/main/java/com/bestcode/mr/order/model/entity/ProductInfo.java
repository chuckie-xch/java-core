package com.bestcode.mr.order.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author xch
 * @create 2018-06-06 22:52
 **/
@Data
@Entity
public class ProductInfo {

    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    /**
     * 0 正常  1 下架
     */
    private Integer productStatus;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;


}
