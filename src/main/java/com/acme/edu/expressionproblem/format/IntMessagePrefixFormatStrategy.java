package com.acme.edu.expressionproblem.format;

import com.acme.edu.expressionproblem.message.Message;

public class IntMessagePrefixFormatStrategy implements FormatStrategy {
    @Override
    public String format(Message message) {
        return "primitive: " + message; //.toString() implicitly called
    }
}
