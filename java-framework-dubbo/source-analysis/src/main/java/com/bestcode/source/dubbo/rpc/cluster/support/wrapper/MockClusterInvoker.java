package com.bestcode.source.dubbo.rpc.cluster.support.wrapper;

import com.bestcode.source.dubbo.common.Constants;
import com.bestcode.source.dubbo.rpc.Invocation;
import com.bestcode.source.dubbo.rpc.Invoker;
import com.bestcode.source.dubbo.rpc.Result;
import com.bestcode.source.dubbo.rpc.RpcException;
import com.bestcode.source.dubbo.rpc.cluster.Directory;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.09
 */
public class MockClusterInvoker<T> implements Invoker<T> {

    private final Directory<T> directory;

    private final Invoker<T> invoker;

    public MockClusterInvoker(Directory<T> directory, Invoker<T> invoker) {
        this.directory = directory;
        this.invoker = invoker;
    }

    public Class<T> getInterface() {
        return null;
    }

    public Result invoke(Invocation invocation) throws RpcException {
        Result result = null;
        String value = directory.getUrl().getMethodParameter(invocation.getMethodName(), Constants.MOCK_KEY, Boolean.FALSE.toString()).trim();
        if (value.length() == 0 || value.equalsIgnoreCase("false")) {
            // no mock
            result = this.invoker.invoke(invocation);
        }
        return result;
    }
}
