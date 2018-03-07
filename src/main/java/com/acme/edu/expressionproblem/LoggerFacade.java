package com.acme.edu.expressionproblem;

import com.acme.edu.expressionproblem.format.PostfixFormatVisitor;
import com.acme.edu.expressionproblem.format.PrefixFormatVisitor;
import com.acme.edu.expressionproblem.message.IntMessage;
import com.acme.edu.expressionproblem.message.StringMessage;
import com.acme.edu.expressionproblem.saver.ConsoleSaver;

public class LoggerFacade {
    private static LoggerController controller = new LoggerController(new com.acme.edu.packagesdemo.businesslogic.services.saver.ConsoleSaver());

    public static void log(int message) {
        controller.execute(new IntMessage(message), new PrefixFormatVisitor());
    }

    public static void log(String message) {
        controller.execute(new StringMessage(message), new PostfixFormatVisitor());
    }
}
