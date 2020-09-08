package refactoring;

import refactoring.message.IntMessage;
import refactoring.message.Message;
import refactoring.message.StringMessage;
import refactoring.save.ConsoleSaver;

public class LoggerFacade {
    private static LoggerController controller =
            new LoggerController(new ConsoleSaver());

    /**
     * Accumulation <- message type
     * State flush decision
     * Decoration <- message type
     * Saving
     * @param message to log.
     * @see Message
     */
    public static void log(int message) {
        controller.log(new IntMessage(message));
    }

    public static void log(String message) {
        controller.log(new StringMessage(message));
    }
}
