package com.bestcode.product.server.exception;


import com.bestcode.product.server.enums.ResultEnum;

/**
 * @author xch
 * @create 2018-06-11 22:59
 **/
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
