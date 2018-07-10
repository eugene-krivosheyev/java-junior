package com.db.edu.simplelogger;

import com.db.edu.simplelogger.filter.Filter;
import com.db.edu.simplelogger.saver.Saver;

public class Logger<T> {

    private final Saver<T> saver;
    private final Filter<T> filter;

    public Logger(Saver<T> saver, Filter<T> filter) {
        this.saver = saver;
        this.filter = filter;
    }

    public void log(T message) {
        if (filter.filter(message)) {
            saver.save(message);
        }
    }
}
