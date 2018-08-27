package com.acme.edu.saver;

import com.acme.edu.decorator.DecoratorVisitor;
import com.acme.edu.message.Message;

public class ConsoleSaver implements LoggerSaver{
    private DecoratorVisitor decorate;

    public ConsoleSaver(DecoratorVisitor decorate) {
        this.decorate = decorate;
    }

    @Override
    public void save(Message message) {
        System.out.println(decorate.visit(message));
    }
}
