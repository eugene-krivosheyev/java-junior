package com.db.edu.simplelogger;

import com.db.edu.simplelogger.filter.MessageLengthFilter;
import com.db.edu.simplelogger.saver.ConsoleSaver;

public class LoggerDemo {

    public static void main(String[] args) {
        new Logger<>(new ConsoleSaver<>(), new MessageLengthFilter(5)).log("qwe");
    }
}
