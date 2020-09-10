package refactoring;

import refactoring.message.Message;
import refactoring.save.Saver;

class LoggerController {
    private final Saver saver;
    private Message currentMessage = new Message() {
        @Override
        public boolean isSameType(Message message) {
            return true;
        }

        @Override
        public Message reduce(Message message) {
            return message;
        }
    };

    public LoggerController(Saver saver) {
        this.saver = saver;
    }

    public void log(Message message) {
        if (currentMessage.isSameType(message)) {
            currentMessage = currentMessage.reduce(message);
        } else {
            saver.save(currentMessage);
            currentMessage = message;
        }
    }
}
