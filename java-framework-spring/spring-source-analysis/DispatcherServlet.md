# DispatcherServlet源码分析

`HandlerMapping`：

* `SimpleUrlHandlerMapping`
* `RequestMappingHandlerMapping`



默认注入的拦截器：

* `ConversionServiceExposingInterceptor`

  向request中注入`conversionService`,主要用于`spring:eval`标签的使用。

* `ResourceUrlProviderExposingInterceptor`

  内置一个`ResourceUrlProvider`，维护了`handlerMap`列表

  * /**/favicon.ico
  * /webjars/**
  * /**``



`HandlerExecutionChain`的结构，主要有三个属性：

* `handler`(~对象)，维护当前请求对应的`Controller`和`method`对象
* `interceptors`(数组)
* `interceptorList`



`DispatcherServlet`默认的三个`handlerAdapter`:

* `RequestMappingHandlerAdapter`

  组合了参数解析器，message转换器，视图解析器等。

* `HttpHandlerAdapter`

* `SimpleControllerHandlerAdapter`



`handlerExecutionChain.applyPreHandle`执行拦截器前置处理。也就是上面提到的两个默认拦截器加上用户自定义的拦截器。



`handlerAdapter.handle`处理请求返回`ModelAndView`。

`RequestMappingHandlerAdapter.handleInternal`处理，其中调用了`invokeHandlerMethod(request, response, handlerMethod)`方法，此处的`handlerMethod`正是前面提到的`HandlerExecutionChain`中的`handler`(也就是controller + method)，



`handlerExecutionChain.applyPostHandle`



调用`processDispatchResult`方法处理异常，渲染view。



总结：

* `DispatherServlet`类的层次结构：

  `DispatcherServlet`--->`FramworkServlet`---->`HttpServletBean`------->`HttpServlet`

* 请求执行过程：

  * `service(HttpServlet)`--->`processRequest(FrameworkServlet)`---->`doService(DispatcherServlet)`----->`doDispatch(DispatcherServlet)`

  * 根据请求和`HandlerMappings`(一般是`RequestMappingHandlerMapping`)获取`HandlerExecutionChain`对象，它包含了要执行的handler（controller和method）,和拦截器链，然后根据`handlerAdapters`和handler返回一个`HandlerAdapter`，

    然后执行执行拦截器链的`preHandle`方法，调用`handlerAdapter`处理请求，并返回`ModelAndView`对象，然后倒序执行拦截器链的`postHandle`方法，最后调用`processDispatchResult`方法处理异常，并调用`render`渲染视图。

