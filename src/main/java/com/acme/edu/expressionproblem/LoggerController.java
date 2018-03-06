package com.acme.edu.expressionproblem;

import com.acme.edu.expressionproblem.format.*;
import com.acme.edu.expressionproblem.message.IntMessage;
import com.acme.edu.expressionproblem.message.Message;
import com.acme.edu.expressionproblem.message.StringMessage;
import com.acme.edu.expressionproblem.saver.LoggerSaver;

public class LoggerController {
    private LoggerSaver saver;
    private FormatStrategy formatStrategy;

    public LoggerController(LoggerSaver saver) {
        this.saver = saver;
    }


    public void execute(Message message, FormatType formatType) {
        if (message instanceof IntMessage) {
            switch (formatType) {
                case PREFIX: formatStrategy = new IntMessagePrefixFormatStrategy(); break;
                case POSTFIX: formatStrategy = new IntMessagePostfixFormatStrategy(); break;
            }
        } else if (message instanceof StringMessage) {
            switch (formatType) {
                case PREFIX: formatStrategy = new StringMessagePrefixFormatStrategy(); break;
                case POSTFIX: formatStrategy = new StringMessagePostfixFormatStrategy(); break;
            }
        }

        saver.save(formatStrategy.format(message));
    }
}
