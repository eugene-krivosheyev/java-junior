package com.acme.edu.expressionproblem;

import com.acme.edu.expressionproblem.message.IntMessage;
import com.acme.edu.expressionproblem.message.StringMessage;
import com.acme.edu.expressionproblem.saver.ConsoleSaver;

import static com.acme.edu.expressionproblem.format.FormatType.POSTFIX;
import static com.acme.edu.expressionproblem.format.FormatType.PREFIX;

public class LoggerFacade {
    private static LoggerController controller = new LoggerController(new ConsoleSaver());

    public static void log(int message) {
        controller.execute(new IntMessage(message), PREFIX);
    }

    public static void log(String message) {
        controller.execute(new StringMessage(message), POSTFIX);
    }
}
