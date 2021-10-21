package controller;

import buffer.Buffer;
import buffer.FlushBuffer;
import message.Message;
import output.ConsolePrinter;
import output.Printer;

import java.util.ArrayList;

public class Controller {
    private Buffer buffer = new FlushBuffer();
    private final Printer printer = new ConsolePrinter();

    public void log(Message message) {
        Buffer newBuffer = message.getBuffer();
        if (Buffer.isNewBufferType(newBuffer.getClass(), this.buffer.getClass())) {
            printer.print(this.buffer.getBody());
            this.buffer = newBuffer;
        }
        this.buffer.accumulate(message);
        try {
            ArrayList<String> result = this.buffer.getExtraordinaryBody();
            String[] array = new String[result.size()];
            printer.print(result.toArray(array));
        } catch (Exception e) {

        }
    }
}
