package ooaddemo;

public class MessageContentLoggerFilter implements LoggerFilter {
    @Override
    public boolean filter(String message) {
        return false;
    }
}
