package com.acme.edu.message;

import com.acme.edu.message.decorator.Decorator;
import com.acme.edu.message.decorator.DefaultDecorator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;


import java.util.Objects;

public class MessageWrapper {
    private String jsonMessage;
    private String type;

    private static final RuntimeTypeAdapterFactory<Message> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
            .of(Message.class, Message.class.getName()) // typeFieldName
            .registerSubtype(IntMessage.class, IntMessage.class.getName())
            .registerSubtype(StringMessage.class, StringMessage.class.getName());
    private static final RuntimeTypeAdapterFactory<Decorator> decoratorRuntimeTypeAdapterFactory = RuntimeTypeAdapterFactory
            .of(Decorator.class, Decorator.class.getName()) // typeFieldName
            .registerSubtype(DefaultDecorator.class, DefaultDecorator.class.getName());
    public static final Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory)
            .registerTypeAdapterFactory(decoratorRuntimeTypeAdapterFactory).create();
    ;

    public String getJsonMessage() {
        return jsonMessage;
    }

    public MessageWrapper(Message message) {
        this.type = message.getClass().getName();
        jsonMessage = gson.toJson(message);

    }

    public String wrap() {
        return gson.toJson(this);
    }

    public Message unwrap() {
        Class messageClass = MessageTypes.TYPES.get(type);

        if (Objects.equals(messageClass, MessageTypes.TYPES.get(IntMessage.class.getName()))) {
            return gson.fromJson(jsonMessage, IntMessage.class);
        }
        if (Objects.equals(messageClass, MessageTypes.TYPES.get(StringMessage.class.getName()))) {
            return gson.fromJson(jsonMessage, StringMessage.class);
        }

        if (Objects.equals(messageClass, MessageTypes.TYPES.get(ByteMessage.class.getName()))) {
            return gson.fromJson(jsonMessage, ByteMessage.class);
        }

        if (Objects.equals(messageClass, MessageTypes.TYPES.get(BoolMessage.class.getName()))) {
            return gson.fromJson(jsonMessage, BoolMessage.class);
        }

        if (Objects.equals(messageClass, MessageTypes.TYPES.get(CharMessage.class.getName()))) {
            return gson.fromJson(jsonMessage, CharMessage.class);
        }
        return null;
    }
}
