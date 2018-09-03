package com.acme.edu.message;

/**
 * Created by Java_1 on 24.08.2018.
 */
public interface Message {
    boolean isSameTypeOf(Message message);

    String getDecoratedMessage();

    void accumulate(Message message);
}
