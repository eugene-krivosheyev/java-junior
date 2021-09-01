package com.db.edu;

import com.db.edu.message.EmptyMessage;
import com.db.edu.message.Message;
import com.db.edu.save.Saver;

import java.io.FileNotFoundException;

public class Controller {
    private Message buffer;
    private final Saver saver;

    public Controller(Saver saver) {
        this.saver = saver;
        this.buffer = new EmptyMessage();
    }

    public void log(Message message) {
        if(message.isStateNotEquals(buffer)) {
            flush();
        }
        buffer = message.accumulate(buffer);
    }

    public void flush() {
        if (buffer.isNotEmpty()) {
            try {
                saver.save(buffer.decorated());
            } catch (SaverException e) {
                e.printStackTrace();
            }
            buffer = buffer.flush();
        }
    }

    public Message getBuffer() {
        return buffer;
    }
}
