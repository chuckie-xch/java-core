package com.bestcode.source.dubbo.rpc;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.09
 */
public interface Invoker<T> {

    Class<T> getInterface();

    Result invoke(Invocation invocation) throws RpcException;
}
