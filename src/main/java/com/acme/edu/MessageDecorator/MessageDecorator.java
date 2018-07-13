package com.acme.edu.MessageDecorator;

public interface MessageDecorator {
    String getDecoratedMessage(int message);
    String getDecoratedMessage(byte message);
    String getDecoratedMessage(char message);
    String getDecoratedMessage(String message);
    String getDecoratedMessage(boolean message);
    String getDecoratedMessage(Object message);
    String getDecoratedMessage(int[] message);
    String getDecoratedMessage(int[][] message);
}
