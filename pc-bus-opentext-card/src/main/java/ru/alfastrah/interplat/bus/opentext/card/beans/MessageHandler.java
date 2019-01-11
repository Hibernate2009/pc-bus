package ru.alfastrah.interplat.bus.opentext.card.beans;

public interface MessageHandler {

    void pull(String message);

    void push(String message);
}
