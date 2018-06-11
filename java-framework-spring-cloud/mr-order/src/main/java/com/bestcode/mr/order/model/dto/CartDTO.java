package com.bestcode.mr.order.model.dto;

import lombok.Data;

/**
 * @author xch
 * @create 2018-06-11 22:53
 **/
@Data
public class CartDTO {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
