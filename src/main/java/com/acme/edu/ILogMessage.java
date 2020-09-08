package com.acme.edu;

public interface ILogMessage {
    boolean IsSameType(ILogMessage message);
    void add(ILogMessage message);
    Object getValue();
}

