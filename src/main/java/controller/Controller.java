package controller;

import accumulator.Accumulator;
import exeption.EmptyAccumulatorException;
import exeption.EmptyMessageException;
import message.Message;
import printer.Printer;

public class Controller {

    private Accumulator accumulator;
    private final Printer printer;

    public Controller(Accumulator accumulator, Printer printer) {
        this.accumulator = accumulator;
        this.printer = printer;
    }

    public void log(Message message) throws EmptyMessageException, EmptyAccumulatorException {
        if (message == null) throw new EmptyMessageException("Attempt to log empty message");
        Accumulator newAccumulator = message.getAccumulator();
        if (newAccumulator == null) throw new EmptyAccumulatorException("Attempt to log message with no accumulator");
        if (newAccumulator.isNewAccumulatorType(this.accumulator.getClass())) {
            printer.print(this.accumulator.getBody());
            this.accumulator = newAccumulator;
        }
        this.accumulator.accumulate(message);
        printUnpromptLines();
    }

    private void printUnpromptLines() {
        String[] result = this.accumulator.extractUnpromtLines();
        if (result != null) {
            printer.print(result);
        }
    }
}
