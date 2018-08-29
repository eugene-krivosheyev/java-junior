package com.acme.edu.Decorator;

import com.acme.edu.message.Message;

/**
 * Created by Java_1 on 27.08.2018.
 */
@FunctionalInterface
public interface Decorator {

    String getDecoratedMessage(Message message);

}