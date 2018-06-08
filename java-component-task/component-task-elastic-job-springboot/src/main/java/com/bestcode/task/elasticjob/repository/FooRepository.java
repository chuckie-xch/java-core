package com.bestcode.task.elasticjob.repository;

import com.bestcode.task.elasticjob.entity.Foo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.06.08
 */
@Repository
public class FooRepository {

    private Map<Long, Foo> data = new ConcurrentHashMap<Long, Foo>(300, 1);

    public FooRepository() {
        init();
    }

    private void init() {
        addData(0L, 100L, "BeiJing");
        addData(100L, 200L, "ShangHai");
        addData(200L, 300L, "HangZhou");
    }

    private void addData(final long idFrom, final long idTo, String location) {
        for (long i = idFrom; i < idTo; i++) {
            data.put(i, new Foo(i, location, Foo.Status.TODO));
        }
    }

    public List<Foo> findTodoData(final String location, final int limit) {
        List<Foo> result = new ArrayList<Foo>(limit);
        int count = 0;
        for (Map.Entry<Long, Foo> entry: data.entrySet()) {
            Foo foo  = entry.getValue();
            if (foo.getLocation().equals(location) && foo.getStatus().equals(Foo.Status.TODO)) {
                result.add(foo);
                count ++;
                if (count >= limit) {
                    break;
                }
            }
        }
        return result;
    }

    public void setCompleted(final long id) {
        data.get(id).setStatus(Foo.Status.COMPLETED);
    }
}
