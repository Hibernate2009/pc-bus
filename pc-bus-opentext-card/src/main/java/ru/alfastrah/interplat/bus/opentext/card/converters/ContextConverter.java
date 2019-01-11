package ru.alfastrah.interplat.bus.opentext.card.converters;

import com.google.gson.Gson;
import ru.alfastrah.interplat.bus.opentext.card.entities.Context;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ContextConverter {

    public static <T> Context<T> createContext(Integer count, String processName, String processId, T request) {
        return new Context<>(request, count, processName, processId);
    }

    public static <T> T extractRequest(String request, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(request, type);
    }

    public static <T> Context<T> extractContext(String value, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(value, type);
    }

    public static <T> String incrementAndCreateJsonContext(Context<T> context) {
        context.setCount(context.getCount() + 1);
        Gson gson = new Gson();
        return gson.toJson(context);
    }

    public static <T> String createJson(T value) {
        Gson gson = new Gson();
        return gson.toJson(value);
    }

    public static Type type(final Class<?> raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }
}
