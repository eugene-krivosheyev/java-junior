package com.acme.edu.saver;

import com.acme.edu.container.MessageContainer;
import com.acme.edu.decorator.MessageDecorator;

public class ConsoleSaver implements LoggerSaver{
    public void save(String message) {
        System.out.println(message);
    }
}
