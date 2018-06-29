package demo.ooad.filter;

import demo.ooad.message.LogSeverityMessage;

/**
 * OCP
 */
public interface MessageFilter {
    boolean filter(LogSeverityMessage message);
}
