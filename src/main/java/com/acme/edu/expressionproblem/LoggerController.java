package com.acme.edu.expressionproblem;

import com.acme.edu.expressionproblem.listener.LoggerListener;
import com.acme.edu.expressionproblem.message.Message;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Implements Observer Pattern [GoF]
 */
public class LoggerController {
    private Set<LoggerListener> observers = new HashSet<>();

    public LoggerController(LoggerListener... observers) {
        this.observers.addAll(Arrays.asList(observers));
    }

    public void execute(Message message) {
        for (LoggerListener observer : observers) {
            observer.fireEvent(message);
        }
    }
}
