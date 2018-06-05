# eureka server的高可用

eureka server通过相互注册实现高可用。

server1的配置：

```properties
spring.application.name=cloud-eureka-server
server.port=8761

eureka.client.service-url.defaultZone=http://127.0.0.1:8762/eureka/
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

server2的配置：

```properties
spring.application.name=cloud-eureka-server
server.port=8762

eureka.client.service-url.defaultZone=http://127.0.0.1:8761/eureka/
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

对于eureka客户端的配置，只需要将server地址列表用","隔开即可，如：

```properties
spring.application.name=cloud-eureka-client

eureka.client.service-url.defaultZone=http://127.0.0.1:8761/eureka/,http://127.0.0.1:8762/eureka/
```

对于这块内容，不在做代码实践，按照如上配置即可实现。