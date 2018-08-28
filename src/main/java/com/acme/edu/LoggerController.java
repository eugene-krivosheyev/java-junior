package com.acme.edu;

import com.acme.edu.message.Message;
import com.acme.edu.saver.ConsoleSaver;

public class LoggerController {
    private Message previousMessage = null;
    private ConsoleSaver saver = new ConsoleSaver();
    public void log(Message message) throws Exception {
        if (previousMessage == null) {
            previousMessage = message;
            return;
        }
        if (message.isSameTypeOf(previousMessage)) {
            previousMessage.accumulate(message);
        } else {
            if (previousMessage != null) {
                saver.save(previousMessage.fetch());
            }
            previousMessage = message;
        }
    }
}
