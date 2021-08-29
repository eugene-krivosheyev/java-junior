package com.acme.edu;
import com.acme.edu.filters.Filter;
import com.acme.edu.messages.*;
import com.acme.edu.checkers.*;
import com.acme.edu.savers.Saver;


public class LoggerController {
    private final Saver saver;
    private final Filter filter;
    private final IntSequenceChecker intChecker;
    private final StringSequenceChecker stringChecker;

    public LoggerController(Saver saver, Filter filter) {
        this.saver = saver;
        this.filter = filter;
        this.intChecker = new IntSequenceChecker(this.saver);
        this.stringChecker = new StringSequenceChecker(this.saver);
        this.saver.setCheckers(intChecker, stringChecker);
    }

    public void log(Message message) {
        if (message == null || message.getValue() == null)
            throw new IllegalArgumentException("null message");

        if (message.getValue().toString().length() == 0) {
            throw new IllegalArgumentException("empty message"); // this works
        }

            if (!filter.filter(message)) {
                saver.save(message);
            }
    }

    public void flush(){
        stringChecker.check(null);
        intChecker.check(null);
    }
}