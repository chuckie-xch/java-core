package com.bestcode.task.elasticjob.entity;

import java.io.Serializable;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.06.08
 */
public class Foo implements Serializable {
    private static final long serialVersionUID = 9044711911148506771L;

    private final long id;
    private final String location;
    private Status status;

    public Foo(long id, String location, Status status) {
        this.id = id;
        this.location = location;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("id: %s, location: %s, status: %s", id, location, status);
    }

    public enum Status {
        TODO,
        COMPLETED
    }
}
