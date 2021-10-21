package controller;

import accumulator.Accumulator;
import accumulator.FlushAccumulator;
import message.Message;
import printer.ConsolePrinter;
import printer.Printer;

import java.util.ArrayList;

public class Controller {
    private Accumulator accumulator = new FlushAccumulator();
    private final Printer printer = new ConsolePrinter();

    public void log(Message message) {
        Accumulator newAccumulator = message.getBuffer();
        if (Accumulator.isNewAccumulatorType(newAccumulator.getClass(), this.accumulator.getClass())) {
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
