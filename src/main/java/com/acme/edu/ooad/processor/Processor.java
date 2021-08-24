package com.acme.edu.ooad.processor;

import com.acme.edu.ooad.message.ObjectMessage;

public abstract class Processor {
    public abstract ObjectMessage[] flush();
}
