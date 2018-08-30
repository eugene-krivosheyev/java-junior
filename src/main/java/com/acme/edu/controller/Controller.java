package com.acme.edu.controller;

import com.acme.edu.decorator.*;
import com.acme.edu.message.FlushMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.MessageType;
import com.acme.edu.saver.DefaultSaver;
import com.acme.edu.saver.Saver;
import com.acme.edu.saver.SavingException;

import java.util.EnumMap;

public class Controller {
    private Saver defaultSaver = new DefaultSaver();
    private Message prevMessage = new FlushMessage();
    private EnumMap<MessageType, Decorator> decoratorMap;

    public Controller() {
        decoratorMap = new EnumMap<>(MessageType.class);
        decoratorMap.put(MessageType.BOOLEAN, new DefaultBooleanDecorator());
        decoratorMap.put(MessageType.BYTE, new DefaultByteDecorator());
        decoratorMap.put(MessageType.CHAR, new DefaultCharDecorator());
        decoratorMap.put(MessageType.FLUSH, new EmptyDecorator());
        decoratorMap.put(MessageType.INT, new DefaultIntDecorator());
        decoratorMap.put(MessageType.INTARRAY, new DefaultIntArrayDecorator());
        decoratorMap.put(MessageType.INTMATRIX, new DefaultIntMatrixDecorator());
        decoratorMap.put(MessageType.REFERENCE, new DefaultReferenceDecorator());
        decoratorMap.put(MessageType.STRING, new DefaultStringDecorator());
    }

    public Controller(Saver saver) {
        this();
        defaultSaver = saver;
    }

    public int log(Message message) {
        if (prevMessage.isAbleToAccumulate(message)) {
            prevMessage = prevMessage.accumulate(message);
        } else {
            try {
                defaultSaver.save(prevMessage.decorate(decoratorMap));
                prevMessage = message;
            } catch (SavingException se) {
                if (se.getExceptionCode() != 1) {
                    return se.getExceptionCode();
                } else {
                    prevMessage = message;
                }
            }
        }
        return 0;
    }

    public int update(MessageType type, Decorator newDecorator) {
        if(newDecorator != null) {
            decoratorMap.put(type, newDecorator);
        } else {
            return 1;
        }
        return 0;
    }
}
