package controller;

import buffer.Buffer;
import message.Message;
import output.ConsoleOutput;
import output.Output;

import java.util.ArrayList;

public class Controller {
    private Buffer buffer = new Buffer();
    private Output output = new ConsoleOutput();

    public void getRequest(Message message, Buffer buffer) {
        if (buffer.isNewBufferType(buffer.getClass(), this.buffer.getClass())) {
            output.send(this.buffer.getBody());
            this.buffer = buffer;
        }
        this.buffer.accumulate(message);
        try {
            ArrayList<String> result = this.buffer.getExtraordinaryBody();
            String[] array = new String[result.size()];
            output.send(result.toArray(array));
        } catch (Exception e) {

        }
    }
}
