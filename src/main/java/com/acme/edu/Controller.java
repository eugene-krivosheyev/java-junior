package com.acme.edu;

import com.acme.edu.message.FlushMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.decorator.*;
import com.acme.edu.saver.DefaultSaver;
import com.acme.edu.saver.Saver;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private Saver defaultSaver = new DefaultSaver();
    private Message prevMessage = new FlushMessage();
    private Map<MessageType, Decorator> decoratorMap;

    public Controller() {
        decoratorMap = new HashMap<>();
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

    public void log(Message message) {
        if (prevMessage.isAbleToAccumulate(message)) {
            prevMessage = prevMessage.accumulate(message);
        } else {
            defaultSaver.save(prevMessage.decorate(decoratorMap));
            prevMessage = message;
        }
    }

    public void update(Decorator newDecorator) {
        newDecorator.update(decoratorMap);
    }
}
