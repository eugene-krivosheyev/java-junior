package newlogger.controller;

import newlogger.message.Message;
import newlogger.saver.Saver;

public class Controller {
    private Message currentMessage;
    private Saver saver;

    public void log(Message message) {
        assert message.getDecoratedMessage() != null : "de_me is null";

        if (currentMessage.isSameTypeOf(message)) {
            this.currentMessage = currentMessage.accumulate(message);
        } else {
            saver.save(currentMessage.getDecoratedMessage());
            this.currentMessage = message;
        }
    }

    public void flush() {

    }
}
