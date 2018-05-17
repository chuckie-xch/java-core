# SpringSecurity核心原理

## SpringSecurity认证的核心原理

首先介绍三个核心组件：
* SecurityContext接口
  提供对Authentication接口的设置获取，即getter,setter方法，获取或者设置认证信息
* SecurityContextHolder
  用来存储安全上下文，默认采用ThreadLocal策略，所以，在任何地方，可以通过如下代码获取认证信息:
```java
Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  if(principal instanceof UserDetails) {
    String username = ((UserDetails)principal).getUsername();
  } else {
    String username = principal.toString();
  }
```  
上述代码描述了如何获取已经认证的用户信息，那么SpringSecurity是如何认证并将认证过的Authentication设置到
SecurityContext中的呢？
实际上，是通过AuthenticationManager接口的authenticate方法执行认证流程的，AuthenticationManager
有个实现类ProviderManager,该类中维护了一个AuthenticationProvider列表，这是典型的委托模式，委托具体
的AuthenticationProvider执行认证。一般的应用场景为基于数据库的DaoAuthenticationProvider来执行
认证逻辑，DaoAuthenticationProvider会委托UserDetailsService的loadUserByUsername方法来拉取用户信息
然后通过additionalAuthenticationChecks来校验密码信息是否正确。
然后ProviderManager会擦除用户密码信息并发布认证成功的事件。在过滤器AbstractAuthenticationProcessingFilter
中的successfulAuthenticaion方法中设置认证信息。

  