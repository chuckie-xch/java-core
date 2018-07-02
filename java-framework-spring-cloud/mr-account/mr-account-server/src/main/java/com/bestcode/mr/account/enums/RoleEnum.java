package com.bestcode.mr.account.enums;

import lombok.Getter;

/**
 * @author xch
 * @create 2018-07-02 21:47
 **/
@Getter
public enum RoleEnum {

    BUYER(1, "买家"),
    SELLER(2, "卖家"),
    ;
    private Integer code;
    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
