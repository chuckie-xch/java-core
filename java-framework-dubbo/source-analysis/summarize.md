## dubbo集群容错架构

调用dubbo接口服务方法时，会执行基于jdk动态代理的代理类InvokerInvocationHandler对象的invoke方法，实际上会调用MockClusterInvoker的invoke方法，通过Directory找到集群中的所有invokers,然后通过Router路由挑选出能正常执行的invokers，如果此时又多个能正常执行的Invoker，会调用loadBalance根据配置的负载均衡策略挑选出需要执行那个invoker，在集群调用失败时，dubbo提供了多种集群容错方案，默认为Failover（失败重试），此外还有Failfast（快速失败），Failsafe（失败安全），Failback（失败回退），FokingClust（并行调用，有一个成功就返回），BroadcastCluster（广播调用，任意一个报错则报错）。



## Directory

Directory代表一个Invoker列表，有两个实现，分别是StaticDirectory，RegistryDiretory,一个是静态的，一个是动态的，RegistryDirectory实现了NotifyListener接口，接受注册中心服务变更的通知，从而改变动态的改变invoker列表。RegistryDirectory通过内部的methodInvokerMap获取invoker列表。当注册中心变化时会通过notify通知RegistryDirectory来更新methodInvokerMap和urlInvokerMap。



## Router

Router有三个实现，分别是MockInvokersSelector，ConditionRouter和ScriptRouter（脚本路由），默认会调用MockInvokersSelector的getNormalInvokes即获取非mock协议的invokers，



## LoadBalance

LoadBalance接口定义如下：

```java
public interface LoadBalance {
    <T> Invoker<T> select(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException;
}
```

该接口有四个实现类，分别是：

* RandomLoadBalance： 随机数算法，这里的随机不是简单的均等随机，而是有权重的概念，会遍历传入的invokers，计算权重并累加，如果权重有不相同的并且，累加权重值大于0，会按照权重计算随机值，并确定随机值落在哪个片段上，否则，就均等随机。
* RoundRobinLoadBalance：
* ConsistentHashLoadBalance：一致性hash
* LeastActiveLoadBalance：最小活跃数，每个服务有一个活跃计数器，处理请求开始时，活跃数+1，请求结束活跃数-1，负载均衡会选择活跃数小的invoker进行调用，因此，可以看出最小活跃数算法是为了让慢的提供者收到更小的请求。




