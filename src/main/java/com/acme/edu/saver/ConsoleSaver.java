package com.acme.edu.saver;

import com.acme.edu.decorator.DecoratorVisitor;
import com.acme.edu.message.Message;

public class ConsoleSaver implements LoggerSaver{
    @Override
    public void save(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
