package com.acme.edu.expressionproblem.format;

import com.acme.edu.expressionproblem.message.IntMessage;
import com.acme.edu.expressionproblem.message.Message;
import com.acme.edu.expressionproblem.message.StringMessage;

public interface FormatVisitor {
    String formatIntMessage(IntMessage message);
    String formatStringMessage(StringMessage message);

    default String format(Message message) {
        return message.accept(this);
    }
}
