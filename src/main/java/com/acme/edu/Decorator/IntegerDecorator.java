package com.acme.edu.Decorator;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;

/**
 * Created by Java_1 on 27.08.2018.
 */
public class IntegerDecorator implements  Decorator {

    public static final String INTEGER = "integer: ";

    @Override
    public String getDecoratedMessage(Message message) {
        return INTEGER + ((IntMessage) message).getValue();
    }
}