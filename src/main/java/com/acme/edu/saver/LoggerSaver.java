package com.acme.edu.saver;

import com.acme.edu.decorator.DecoratorVisitor;
import com.acme.edu.message.Message;

@FunctionalInterface
public interface LoggerSaver {
    void save(String decoratedMessage);
}
