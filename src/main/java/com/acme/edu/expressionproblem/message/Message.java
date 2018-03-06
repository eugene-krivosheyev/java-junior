package com.acme.edu.expressionproblem.message;

import com.acme.edu.expressionproblem.format.FormatVisitor;

public interface Message {
    String toString();

    String accept(FormatVisitor formatVisitor);
}
