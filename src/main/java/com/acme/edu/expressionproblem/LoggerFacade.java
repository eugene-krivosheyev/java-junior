package com.acme.edu.expressionproblem;

import com.acme.edu.expressionproblem.listener.IntPrefixFormatMessageListener;
import com.acme.edu.expressionproblem.listener.StringPrefixFormatMessageListener;
import com.acme.edu.expressionproblem.message.IntMessage;
import com.acme.edu.expressionproblem.message.StringMessage;
import com.acme.edu.expressionproblem.saver.ConsoleSaver;

public class LoggerFacade {
    private static LoggerController controller = new LoggerController(
            new StringPrefixFormatMessageListener(new ConsoleSaver()),
            new IntPrefixFormatMessageListener(new ConsoleSaver())
    );

    public static void log(int message) {
        controller.execute(new IntMessage(message));
    }

    public static void log(String message) {
        controller.execute(new StringMessage(message));
    }
}
