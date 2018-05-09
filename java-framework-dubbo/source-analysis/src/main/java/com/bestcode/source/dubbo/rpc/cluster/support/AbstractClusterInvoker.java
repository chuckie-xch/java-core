package com.bestcode.source.dubbo.rpc.cluster.support;

import com.bestcode.source.dubbo.rpc.Invocation;
import com.bestcode.source.dubbo.rpc.Invoker;
import com.bestcode.source.dubbo.rpc.Result;
import com.bestcode.source.dubbo.rpc.RpcException;
import com.bestcode.source.dubbo.rpc.cluster.Directory;

import java.util.List;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.09
 */
public abstract class AbstractClusterInvoker<T> implements Invoker<T> {

    /**
     * RegistryDirectory{
     *
     *
     * }
     */
    protected final Directory<T> directory;

    protected AbstractClusterInvoker(Directory<T> directory) {
        this.directory = directory;
    }


    /**
     *
     * @param invocation RpcInvocation {methodName = "findByName", parameterTypes:[class.lang.String],arguments: ["张三丰"],invoker:null}
     * @return
     * @throws RpcException
     */
    public Result invoke(Invocation invocation) throws RpcException {

        List<Invoker<T>> invokers = list(invocation);
        return null;
    }

    protected  List<Invoker<T>> list(Invocation invocation) throws RpcException{
        List<Invoker<T>> invokers = directory.list(invocation);
        return invokers;
    }
}
