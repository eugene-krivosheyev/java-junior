package com.acme.edu;

import com.acme.edu.LogWorkerDelegates.ByteLogWorkerDelegate;
import com.acme.edu.LogWorkerDelegates.IntegerLogWorkerDelegate;
import com.acme.edu.LogWorkerDelegates.StringLogWorkerDelegate;
import com.acme.edu.MessageDecorator.MessageDecorator;
import com.acme.edu.Saver.Saver;

public class LogWorker {
    private Saver saver;
    private MessageDecorator messageDecorator;
    private IntegerLogWorkerDelegate integerLogWorkerDelegate;
    private ByteLogWorkerDelegate byteLogWorkerDelegate;
    private StringLogWorkerDelegate stringLogWorkerDelegate;

    LogWorker(Saver saver, MessageDecorator messageDecorator) {
        this.saver = saver;
        this.messageDecorator = messageDecorator;
        this.integerLogWorkerDelegate = new IntegerLogWorkerDelegate(saver, messageDecorator);
        this.byteLogWorkerDelegate = new ByteLogWorkerDelegate(saver, messageDecorator);
        this.stringLogWorkerDelegate = new StringLogWorkerDelegate(saver, messageDecorator);
    }

    public void log(int message) {
        flushStringBuffer();
        integerLogWorkerDelegate.log(message);
    }

    public void log(byte message) {
        flushBuffers();
        byteLogWorkerDelegate.log(message);
    }

    public void log(char message) {
        flushBuffers();
        saver.save(messageDecorator.getDecoratedMessage(message));
    }

    public void log(String message) {
        flushIntegerBuffer();
        stringLogWorkerDelegate.log(message);
    }

    public void log(boolean message) {
        flushBuffers();
        saver.save(messageDecorator.getDecoratedMessage(message));
    }

    public void log(Object message) {
        flushBuffers();
        saver.save(messageDecorator.getDecoratedMessage(message));
    }

    public void log(int[] message) {
        flushBuffers();
        saver.save(messageDecorator.getDecoratedMessage(message));
    }
    public void log(int[][] message) {
        flushBuffers();
        saver.save(messageDecorator.getDecoratedMessage(message));
    }

    public void flushIntegerBuffer() {
        integerLogWorkerDelegate.flushBuffer();
    }

    public void flushStringBuffer() {
        stringLogWorkerDelegate.flushBuffer();
    }

    private void flushBuffers() {
        flushIntegerBuffer();
        flushStringBuffer();
    }
}
