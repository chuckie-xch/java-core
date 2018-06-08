package com.bestcode.task.elasticjob.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * elastic-job注册中心配置 (zk)
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.06.08
 */
@Configuration
@ConditionalOnExpression("'${registryCenter.serverList}'.length() > 0")
public class RegistryCenterConfig {

    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter registryCenter(@Value("${registryCenter.serverList}") String serverList, @Value
            ("${registryCenter.namespace}") String namespace) {
       return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList, namespace));
    }
}
