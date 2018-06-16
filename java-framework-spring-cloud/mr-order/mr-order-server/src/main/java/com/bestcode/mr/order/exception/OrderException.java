package com.bestcode.mr.order.exception;

import com.bestcode.mr.order.enums.ResultEnum;

/**
 * @author xch
 * @create 2018-06-08 22:51
 **/
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
