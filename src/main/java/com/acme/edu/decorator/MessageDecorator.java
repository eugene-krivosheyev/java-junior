package com.acme.edu.decorator;

import com.acme.edu.container.MessageContainer;

import java.util.ArrayList;

public interface MessageDecorator {
    public String decorate(ArrayList<MessageContainer> messages);
}
