package ru.alfastrah.interplat.bus.opentext.card.entities;

import java.util.Objects;

public class Context<T> {
    private T object;
    private Integer count;
    private String processName;
    private String processId;

    public Context() {
    }

    public Context(T object, Integer count, String processName, String processId) {
        this.object = object;
        this.count = count;
        this.processName = processName;
        this.processId = processId;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @Override
    public String toString() {
        return "Context{" +
                "object=" + object +
                ", count=" + count +
                ", processName='" + processName + '\'' +
                ", processId='" + processId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Context<?> context = (Context<?>) o;
        return Objects.equals(object, context.object) &&
                Objects.equals(count, context.count) &&
                Objects.equals(processName, context.processName) &&
                Objects.equals(processId, context.processId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(object, count, processName, processId);
    }
}
