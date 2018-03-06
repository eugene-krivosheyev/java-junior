package com.acme.edu.expressionproblem.format;

import com.acme.edu.expressionproblem.message.IntMessage;
import com.acme.edu.expressionproblem.message.StringMessage;

public class PrefixFormatVisitor implements FormatVisitor {
    @Override
    public String formatIntMessage(IntMessage message) {
        return "primitive: " + message;
    }

    @Override
    public String formatStringMessage(StringMessage message) {
        return "string: " + message;
    }
}
