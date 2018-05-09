package com.bestcode.source.dubbo.registry.integration;

import com.bestcode.source.dubbo.common.URL;
import com.bestcode.source.dubbo.rpc.Invocation;
import com.bestcode.source.dubbo.rpc.Invoker;
import com.bestcode.source.dubbo.rpc.RpcException;
import com.bestcode.source.dubbo.rpc.cluster.directory.AbstractDirectory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.09
 */
public class RegistryDirectory<T> extends AbstractDirectory<T> {

    private final URL directoryUrl;

    private volatile boolean forbidden = false;

    private volatile Map<String,List<Invoker<T>>> methodInvokerMap;

    public RegistryDirectory(URL directoryUrl) {
        this.directoryUrl = directoryUrl;
    }

    public Class<T> getInterfaces() {
        return null;
    }

    public URL getUrl() {
        return null;
    }

    protected List<Invoker<T>> doList(Invocation invocation) throws RpcException {
        if (forbidden) {
            throw new RpcException("forbidden consumer");
        }
        List<Invoker<T>> invokers = null;
        Map<String,List<Invoker<T>>> localMethodInvokerMap = this.methodInvokerMap;
        if (localMethodInvokerMap != null && localMethodInvokerMap.size() > 0) {
            String methodName = invocation.getMethodName();
            Object[] args = invocation.getArguments();
        }
        return invokers == null ? new ArrayList<Invoker<T>>(0) : invokers;
    }
}
