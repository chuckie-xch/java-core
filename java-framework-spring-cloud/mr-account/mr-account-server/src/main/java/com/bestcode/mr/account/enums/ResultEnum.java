package com.bestcode.mr.account.enums;

import lombok.Getter;

/**
 * @author xch
 * @create 2018-06-08 22:52
 **/
@Getter
public enum ResultEnum {

    LOGIN_FAIL(-1, "登录失败"),
    ROLE_ERROR(2, "角色权限有误"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
