package com.bestcode.product.server.enums;

import lombok.Getter;

/**
 * 商品上下架状态
 * @author xch
 * @create 2018-06-07 22:04
 **/
@Getter
public enum  ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1, "下架"),
    ;
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
