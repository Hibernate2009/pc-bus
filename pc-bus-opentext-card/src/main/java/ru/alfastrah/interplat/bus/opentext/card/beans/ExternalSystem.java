package ru.alfastrah.interplat.bus.opentext.card.beans;


import ru.alfastrah.interplat.bus.opentext.card.entities.Context;

import java.lang.reflect.Type;

public interface ExternalSystem<T, K> {

    K send(Context<T> context) throws Exception;

    void onSuccess(K response, Context<T> context);

    void onFailed(Context<T> context);

    void resend(Context<T> context);

    Type getContextType();
}
