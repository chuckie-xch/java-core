package com.bestcode.mr.account.model;

import lombok.Data;

/**
 * @author xch
 * @create 2018-06-07 22:20
 **/
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;
}
