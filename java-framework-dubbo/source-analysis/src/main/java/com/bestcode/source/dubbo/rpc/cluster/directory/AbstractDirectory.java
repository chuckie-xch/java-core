package com.bestcode.source.dubbo.rpc.cluster.directory;

import com.bestcode.source.dubbo.rpc.Invocation;
import com.bestcode.source.dubbo.rpc.Invoker;
import com.bestcode.source.dubbo.rpc.RpcException;
import com.bestcode.source.dubbo.rpc.cluster.Directory;

import java.util.List;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.09
 */
public abstract class AbstractDirectory<T> implements Directory<T> {

    private volatile boolean destroy;

    public List<Invoker<T>> list(Invocation invocation) throws RpcException {
        if (destroy) {
            throw new RpcException("Directory already destroyed");
        }
        List<Invoker<T>> invokers = doList(invocation);
        return null;
    }

    protected abstract List<Invoker<T>> doList(Invocation invocation) throws RpcException;
}
