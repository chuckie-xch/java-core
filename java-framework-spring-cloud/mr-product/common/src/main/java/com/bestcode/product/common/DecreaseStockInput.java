package com.bestcode.product.common;

import lombok.Data;

/**
 * @author xch
 * @create 2018-06-13 23:43
 **/
@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
