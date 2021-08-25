package com.db.edu;

import com.db.edu.message.*;
import com.db.edu.saver.ConsoleSaver;
import com.db.edu.saver.Saver;

import static com.db.edu.message.ByteMessage.flushByte;
import static com.db.edu.message.IntMessage.flushInt;
import static com.db.edu.Prefix.*;
import static com.db.edu.message.StringMessage.flushString;

public class Controller {
    private Message accumulateMessage;
//    private static Object type;
    private static final Saver saver = new ConsoleSaver();

    public static void flush() {
        if (type == null) return;
        if (type instanceof Integer) {
            flushInt();
        } else if (type instanceof Byte) {
            flushByte();
        } else if (type instanceof String) {
            flushString();
        }
    }

    public void log(Message message) {
       if (message.getClass() == accumulateMessage.getClass()) {
           accumulateMessage.accumulate(message);
       }
    }

    public void log(BooleanMessage message) {
        saver.save(PRIMITIVE_PREFIX.getMessage() + message);
    }

    public void log(char message) {
        saver.save(CHAR_PREFIX.getMessage() + message);
    }

    public void log(Object message) {
        saver.save(OBJECT_PREFIX.getMessage() + message);
    }

    public void log(int ... message) {
        for (int value : message) {
            log(new IntMessage(value));
        }
        flush();
    }

    public void log(String ... message) {
        for (String value : message) {
            log(new StringMessage(value));
        }
        flush();
    }

}
