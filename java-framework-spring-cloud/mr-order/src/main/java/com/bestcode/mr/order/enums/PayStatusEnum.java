package com.bestcode.mr.order.enums;

import lombok.Getter;

/**
 * @author xch
 * @create 2018-06-07 23:48
 **/
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
