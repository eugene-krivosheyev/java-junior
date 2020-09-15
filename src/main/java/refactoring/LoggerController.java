package refactoring;

import refactoring.message.Message;
import refactoring.save.Saver;

import java.util.Arrays;

import static java.util.Arrays.asList;

class LoggerController {
    private final Iterable<Saver> savers;

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

    public LoggerController(Saver... saver) {
        this.savers = asList(saver);
    }

    public void log(Message message) {
        if (currentMessage.isSameType(message)) {
            currentMessage = currentMessage.reduce(message);
        } else {
            savers.forEach(s -> s.save(currentMessage));
            currentMessage = message;
        }
    }
}
