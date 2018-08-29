package com.acme.edu.Decorator;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;

/**
 * Created by Java_1 on 27.08.2018.
 */
public class PrimitiveDecorator implements Decorator {

    public static final String PRIMITIVE = "primitive: ";

    @Override
    public String getDecoratedMessage(Message message) {
        return PRIMITIVE + ((IntMessage) message).getValue();
    }
}