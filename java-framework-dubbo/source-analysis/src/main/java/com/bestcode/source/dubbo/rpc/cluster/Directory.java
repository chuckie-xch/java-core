package com.bestcode.source.dubbo.rpc.cluster;

import com.bestcode.source.dubbo.common.Node;
import com.bestcode.source.dubbo.rpc.Invocation;
import com.bestcode.source.dubbo.rpc.Invoker;
import com.bestcode.source.dubbo.rpc.RpcException;

import java.util.List;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.09
 */
public interface Directory<T> extends Node{

    Class<T> getInterfaces();

    List<Invoker<T>> list(Invocation invocation) throws RpcException;
}
