package com.db.edu.simplelogger.filter;

public interface Filter<T> {
    boolean filter(T message);
}
