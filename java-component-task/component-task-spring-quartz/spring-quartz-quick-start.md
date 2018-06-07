# SpringBoot + quartz  quick start

## quick start

在pom中加入如下依赖：

```xml
<dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.quartz-scheduler</groupId>
            <artifactId>quartz</artifactId>
            <version>2.3.0</version>
        </dependency>
    </dependencies>


    <dependencyManagement>
        <dependencies>
            <dependency>
                <!-- Import dependency management from Spring Boot -->
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>1.5.9.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```

新增SpringBoot启动类，加上`@EnableScheduling` 注解：

```java
@SpringBootApplication
@EnableScheduling
public class SpringQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringQuartzApplication.class, args);
    }
}
```

添加任务的执行类：HelloTask:

```java
@Component
public class HelloTask {

    public void sayHello() {
        System.out.println("Hello quartz");
    }
}
```

增加quartz的配置类：

```java
@Configuration
public class JobConfig {

    @Bean("jobDetail")
    public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean(HelloTask task) {
        MethodInvokingJobDetailFactoryBean factoryBean = new MethodInvokingJobDetailFactoryBean();
        factoryBean.setConcurrent(false);
        factoryBean.setTargetObject(task);
        // 执行目标对象的sayHello方法
        factoryBean.setTargetMethod("sayHello");
        return factoryBean;
    }
	
    @Bean("cronJobTrigger")
    public CronTriggerFactoryBean cronTriggerFactoryBean(MethodInvokingJobDetailFactoryBean jobDetail) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetail.getObject());
        // 每10秒钟执行一次
        cronTriggerFactoryBean.setCronExpression("*/10 * * * * ?");
        return cronTriggerFactoryBean;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(Trigger cronJobTrigger) {

        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setStartupDelay(1);
        // 用于集群，启动时更新已存在的job
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setTriggers(cronJobTrigger);
        return schedulerFactoryBean;
    }

}
```



## cron表达式

Cron表达式的格式为“秒   分     时     日     月    周    年”，各字段用法如下：

| 字段         | 允许值            | 允许的特殊字符  |
| ------------ | ----------------- | --------------- |
| 秒           | 0-59              | , - * /         |
| 分           | 0-59              | , - * /         |
| 小时         | 0-23              | , - * /         |
| 日期         | 1-31              | , - * ? / L W C |
| 月份         | 1-12 或者 JAN-DEC | , - * /         |
| 星期         | 1-7 或者 SUN-SAT  | , - * ? / L C # |
| 年（可为空） | 留空, 1970-2099   | , - * /         |

 其中，特殊字符的含义如下：

* "？"字符：表示不确定的值。
* “，”字符：指定数个数。
* “-”字符：指定一个值得范围。
* “/”字符：指定一个值得增加幅度。n/m表示从n开始，每次增加m。
* “L”字符：用在日表示一个月的最后一天，用在周表示该月最后一个星期X。
* “W”字符：指定离给定日期最近的工作日（周一到周五）。
* “#”字符：表示该月第几个周X。6#3表示该月第三个周五。

表达式示例如下：

* 每隔5秒执行一次：*/5   *   *   *  *  ?
* 每隔一分钟执行一次：0  */1  *   *   *  ?
* 每天23点执行一次：0  0   23  *   *   ？
* 每天凌晨1点执行一次：0   0   1  *   *  ？
* 每月1号凌晨1点执行一次：0   0  1  1  *   ？
* 每月最后一天23点执行一次：0  0   23   L   *   ?
* 每周星期天凌晨1点执行一次：0  0   1  ？  *   L 
* 在26分、29分、33分执行一次：0  26,29,33 *  *   *  ?
* 每天的0点，13点，18点，21点都执行一次：0  0  0,13,18,21  *  *   ?

 

> 推荐使用工具来生成cron表达式，这样效率更高且不容易出错，这里推荐一款在线工具：（http://www.pppet.net）,效果如下：



 [![cron在线生成器.png](https://i.loli.net/2018/06/06/5b17a05934bc9.png)](https://i.loli.net/2018/06/06/5b17a05934bc9.png)

 

 