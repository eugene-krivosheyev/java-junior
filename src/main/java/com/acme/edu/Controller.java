package com.acme.edu;

import com.acme.edu.message.*;

public class Controller {

    private Message currentType;
    private final Saver saver;

    public Controller(Saver saver) {
        this.saver = saver;
    }

    public void log(Message message) {
        if (currentType != null) {
            if (!currentType.isSameType(message)) {
                flush();
                currentType = message;
            } else {
                currentType.process(message);
            }
        } else {
            currentType = message;
        }
    }

    public void flush() {
        saver.save(currentType.decorate());
        currentType = null;
    }

}
