package ru.alfastrah.interplat.bus.opentext.card.beans;

public interface SystemConfig {
    Integer getCountLimit();

    Integer getRedeliveryDelay();

    String getQueueName();
}
