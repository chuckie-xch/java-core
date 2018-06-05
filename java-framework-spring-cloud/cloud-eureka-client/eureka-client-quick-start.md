# Eureka Client quick start

在java-framework-spring-cloud下新建模块，并在pom中加入eureka client的依赖：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
</dependencies>
```

新增application.properties：

```properties
spring.application.name=cloud-eureka-client

eureka.client.service-url.defaultZone=http://127.0.0.1:8761/eureka/
```

> 注意：这里配置的eureka.client.service-url.defaultZone是eureka-server服务暴露注册中心地址，所以要启动之前的eureka-server的服务。

在SpringBoot启动类上打上eureka client的annotation：

```java
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
```

启动服务，打开http://127.0.0.1:8761，观察服务上下线情况。