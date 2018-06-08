package com.bestcode.task.elasticjob.config;

import com.bestcode.task.elasticjob.job.simple.SpringSimpleJob;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.06.08
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Configuration
public class SimpleJobConfig {

    @Autowired
    private ZookeeperRegistryCenter registryCenter;

    @Autowired
    private JobEventConfiguration jobEventConfiguration;

    @Bean
    public SimpleJob simpleJob() {
        return new SpringSimpleJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler(final SimpleJob simpleJob, @Value("${simpleJob.cron}") final String cron,
                                           @Value("${simpleJob.shardingTotalCount}") final int
            shardingTotalCount,@Value("${simpleJob.shardingItemParameters}") final String shardingItemParameters) {
        return new SpringJobScheduler(simpleJob, registryCenter, getLiteJobConfiguration(simpleJob.getClass(), cron,
                shardingTotalCount, shardingItemParameters), jobEventConfiguration);
    }

    public LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass, String cron,
                                                        int shardingTotalCount, String shardingItemParameters) {
        return LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(JobCoreConfiguration.newBuilder(jobClass
                .getName(), cron, shardingTotalCount).shardingItemParameters(shardingItemParameters).build(),
                jobClass.getCanonicalName()))
                .overwrite(true).build();
    }
}
