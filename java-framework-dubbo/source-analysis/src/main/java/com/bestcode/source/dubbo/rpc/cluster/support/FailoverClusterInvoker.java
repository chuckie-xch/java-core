package com.bestcode.source.dubbo.rpc.cluster.support;

import com.bestcode.source.dubbo.rpc.Invocation;
import com.bestcode.source.dubbo.rpc.Result;
import com.bestcode.source.dubbo.rpc.RpcException;

/**
 * 失败转移，当出现失败，重试其他服务器，通常用于读操作，但重试会带来更长延迟。
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.09
 */
public class FailoverClusterInvoker<T> extends AbstractClusterInvoker<T> {
    public Class<T> getInterface() {
        return null;
    }

    @Override
    public Result invoke(Invocation invocation) throws RpcException {
        return null;
    }
}
