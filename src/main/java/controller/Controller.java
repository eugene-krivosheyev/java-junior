package controller;

import buffer.Buffer;
import message.Message;
import output.ConsolePrinter;
import output.Printer;

import java.util.ArrayList;

public class Controller {
    private Buffer buffer = new Buffer();
    private Printer printer = new ConsolePrinter();

    public void log(Message message, Buffer buffer) {
        if (buffer.isNewBufferType(buffer.getClass(), this.buffer.getClass())) {
            printer.print(this.buffer.getBody());
            this.buffer = buffer;
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
