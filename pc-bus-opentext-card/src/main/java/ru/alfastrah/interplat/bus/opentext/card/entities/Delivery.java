package ru.alfastrah.interplat.bus.opentext.card.entities;

import org.joda.time.LocalDateTime;

import java.util.Objects;

public class Delivery {
    private String uuid;
    private String queue;
    private String context;
    private LocalDateTime time;

    public Delivery() {
    }

    public Delivery(String uuid, String queue, String context, LocalDateTime time) {
        this.uuid = uuid;
        this.queue = queue;
        this.context = context;
        this.time = time;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(uuid, delivery.uuid) &&
                Objects.equals(queue, delivery.queue) &&
                Objects.equals(context, delivery.context) &&
                Objects.equals(time, delivery.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid, queue, context, time);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "uuid='" + uuid + '\'' +
                ", queue='" + queue + '\'' +
                ", context='" + context + '\'' +
                ", time=" + time +
                '}';
    }
}
