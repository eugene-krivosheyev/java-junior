package com.acme.edu.expressionproblem.format;

import com.acme.edu.expressionproblem.message.IntMessage;
import com.acme.edu.expressionproblem.message.StringMessage;

public class PostfixFormatVisitor implements FormatVisitor {
    @Override
    public String formatIntMessage(IntMessage message) {
        return message + " (primitive)";
    }

    @Override
    public String formatStringMessage(StringMessage message) {
        return message + " (string)";
    }
}
