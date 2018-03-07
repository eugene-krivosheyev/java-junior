package com.acme.edu.expressionproblem;

import com.acme.edu.expressionproblem.format.*;
import com.acme.edu.expressionproblem.message.Message;
import com.acme.edu.expressionproblem.saver.LoggerSaver;
import com.acme.edu.packagesdemo.businesslogic.services.saver.Saver;


public class LoggerController {
    private LoggerSaver saver;

    public LoggerController(Saver saver) {
//        this.saver = saver;
    }


    public void execute(Message message, FormatVisitor formatter) {
        saver.save(formatter.format(message));
    }
}
