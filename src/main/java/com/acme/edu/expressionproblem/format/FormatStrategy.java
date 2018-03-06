package com.acme.edu.expressionproblem.format;

import com.acme.edu.expressionproblem.message.Message;

public interface FormatStrategy {
    String format(Message message);
}
