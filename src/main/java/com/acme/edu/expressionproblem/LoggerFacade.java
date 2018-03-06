package com.acme.edu.expressionproblem;

import com.acme.edu.expressionproblem.handler.IntPrefixFormatMessageHandler;
import com.acme.edu.expressionproblem.handler.LoggerHandler;
import com.acme.edu.expressionproblem.handler.StringPrefixFormatMessageHandler;
import com.acme.edu.expressionproblem.message.IntMessage;
import com.acme.edu.expressionproblem.message.StringMessage;
import com.acme.edu.expressionproblem.saver.ConsoleSaver;

public class LoggerFacade {
    private static LoggerHandler chain = new IntPrefixFormatMessageHandler(
        new ConsoleSaver(),
        new StringPrefixFormatMessageHandler(
            new ConsoleSaver(),
            null
        )
    );


    public static void log(int message) {
        chain.handleMessage(new IntMessage(message));
    }

    public static void log(String message) {
        chain.handleMessage(new StringMessage(message));
    }
}
