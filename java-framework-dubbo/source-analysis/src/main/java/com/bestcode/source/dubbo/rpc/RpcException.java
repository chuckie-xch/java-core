package com.bestcode.source.dubbo.rpc;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.09
 */
public class RpcException extends RuntimeException{

    private String code;

    public RpcException(String code) {
        this.code = code;
    }

    public RpcException(String message, String code) {
        super(message);
        this.code = code;
    }

    public RpcException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public RpcException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public RpcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
                        String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
