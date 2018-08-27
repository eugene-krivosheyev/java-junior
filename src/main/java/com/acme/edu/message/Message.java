package com.acme.edu.message;

import com.acme.edu.decorator.DecoratorVisitor;

public interface Message {
    boolean isSameTypeOf(Message message);
    Message accumulate(Message message);
    String accept(DecoratorVisitor decoratorVisitor);
}
