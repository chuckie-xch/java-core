package com.bestcode.task.elasticjob.job.dataflow;

import com.bestcode.task.elasticjob.entity.Foo;
import com.bestcode.task.elasticjob.repository.FooRepository;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.06.08
 */
public class SpringDataflowJob implements DataflowJob<Foo> {

    @Autowired
    private FooRepository fooRepository;

    @Override
    public List<Foo> fetchData(ShardingContext shardingContext) {
        System.out.println(String.format("DataflowJob Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread
                        .currentThread().getId(), "DATAFLOW FETCH"));
        return fooRepository.findTodoData(shardingContext.getShardingParameter(), 10);
    }

    @Override
    public void processData(ShardingContext shardingContext, List<Foo> data) {
        System.out.println(String.format("DataflowJob Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread
                        .currentThread().getId(), "DATAFLOW PROCESS"));
        for (Foo foo : data) {
            fooRepository.setCompleted(foo.getId());
            System.out.println(foo);
        }
    }
}
