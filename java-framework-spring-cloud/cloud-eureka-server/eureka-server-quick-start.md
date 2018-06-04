# Spring Cloud Eureka

* 基于Netflix Eureka做了二次封装
* 两个组件组成：
  * Eureka Server 注册中心
  * Eureka Client 客户端

## quick start

新建maven项目java-framework-spring-cloud，pom中packing改为pom，加入dependencyManagement依赖管理：

```xml
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <java.vesion>1.8</java.vesion>
    <spring-boot.version>2.0.0.M3</spring-boot.version>
    <spring-cloud.version>Finchley.M2</spring-cloud.version>
</properties>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>${spring-boot.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring-cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

<repositories>
    <repository>
        <id>spring-milestones</id>
        <name>Spring Milestones</name>
        <url>https://repo.spring.io/libs-milestone</url>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </repository>
</repositories>
```

在java-framework-spring-cloud下新建cloud-eureka-server模块，加入如下依赖：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-eureka-server</artifactId>
    </dependency>
</dependencies>
```



创建SpringBoot启动类，EurekaServerApplication：

```java
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
```

创建application.properties文件：

```properties
spring.application.name=cloud-eureka-server
server.port=8761

eureka.client.service-url.defaultZone=http://127.0.0.1:8761/eureka/
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

启动，打开浏览器，输入：http://127.0.0.1:8761

