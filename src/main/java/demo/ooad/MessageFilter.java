package demo.ooad;

import demo.ooad.message.LogSeverityMessage;

/**
 * OCP
 */
public interface MessageFilter {
    boolean filter(LogSeverityMessage message);
}
