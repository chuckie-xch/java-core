package com.bestcode.task.elasticjob.job.simple;

import com.bestcode.task.elasticjob.entity.Foo;
import com.bestcode.task.elasticjob.repository.FooRepository;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.06.08
 */
public class SpringSimpleJob implements SimpleJob {

    @Autowired
    private FooRepository fooRepository;

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println(String.format("SimpleJob Item : %s | Time: %s | Thread: %s | %s", shardingContext
                        .getShardingItem(),
                new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread.currentThread().getId(), "SIMPLE"));
        System.out.println("SimpleJob: " + shardingContext.getShardingParameter());
        List<Foo> foos = fooRepository.findTodoData(shardingContext.getShardingParameter(), 10);
        for (Foo foo : foos) {
            fooRepository.setCompleted(foo.getId());
            System.out.println("SimpleJob: " + foo);
        }
    }
}
