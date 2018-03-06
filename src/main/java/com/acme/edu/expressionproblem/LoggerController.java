package com.acme.edu.expressionproblem;

import com.acme.edu.expressionproblem.format.*;
import com.acme.edu.expressionproblem.message.Message;
import com.acme.edu.expressionproblem.saver.LoggerSaver;


public class LoggerController {
    private LoggerSaver saver;

    public LoggerController(LoggerSaver saver) {
        this.saver = saver;
    }


    public void execute(Message message, FormatVisitor formatter) {
        saver.save(formatter.format(message));
    }
}
