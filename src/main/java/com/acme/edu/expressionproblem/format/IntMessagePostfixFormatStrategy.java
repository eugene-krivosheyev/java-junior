package com.acme.edu.expressionproblem.format;

import com.acme.edu.expressionproblem.message.Message;

public class IntMessagePostfixFormatStrategy implements FormatStrategy {
    @Override
    public String format(Message message) {
        return message + " (primitive)";
    }
}
