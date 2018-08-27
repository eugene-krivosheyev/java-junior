package com.acme.edu.saver;

import com.acme.edu.decorator.DecoratorVisitor;
import com.acme.edu.message.Message;

public interface LoggerSaver {
    void save(Message message);
}
