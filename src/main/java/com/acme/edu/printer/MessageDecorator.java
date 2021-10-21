package com.acme.edu.printer;

import com.acme.edu.message.DataEqualMessage;

public interface MessageDecorator {
    String decorate(DataEqualMessage message);
}
