package com.acme.edu;

import com.acme.edu.message.*;

public class Controller {

    private Message currentType;

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
        System.out.println(currentType.decorate());
        currentType = null;
    }

}
