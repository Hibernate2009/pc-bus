package ru.alfastrah.interplat.bus.opentext.card.beans;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import ru.alfastrah.interplat.bus.opentext.card.entities.Context;
import ru.alfastrah.interplat.bus.opentext.card.entities.Delivery;

import java.util.UUID;

import static ru.alfastrah.interplat.bus.opentext.card.converters.ContextConverter.*;

public abstract class DefaultExternalSystem<T, K> implements ExternalSystem<T, K>, MessageHandler, SystemConfig {

    @Autowired
    private DeliveryManager deliveryManager;

    @Override
    public void pull(String value) {
        Context<T> context = extractContext(value, getContextType());
        execute(context);
    }

    private void execute(Context<T> context) {
        if (isLimitExceeded(context)) {
            onFailed(context);
        } else {
            doAttempt(context);
        }
    }

    @Override
    public void push(String context) {
        Delivery delivery = new Delivery(UUID.randomUUID().toString(), getQueueName(), context, LocalDateTime.now());
        deliveryManager.invoke(delivery);
    }

    @Override
    public void resend(Context<T> context) {
        Delivery delivery = new Delivery(UUID.randomUUID().toString(), getQueueName(), incrementAndCreateJsonContext(context), LocalDateTime.now().plusSeconds(getRedeliveryDelay()));
        deliveryManager.invoke(delivery);
    }

    private void doAttempt(Context<T> context) {
        try {
            K response = send(context);
            onSuccess(response, context);
        } catch (Exception e) {
            resend(context);
        }
    }

    private boolean isLimitExceeded(Context<T> context) {
        return context.getCount() >= getCountLimit();
    }
}
