package ooaddemo;

import java.io.Serializable;

public class MessageContentLoggerFilter
        implements LoggerFilter, Serializable {

    @Override
    public boolean filter(String message) {
        return false;
    }
}
