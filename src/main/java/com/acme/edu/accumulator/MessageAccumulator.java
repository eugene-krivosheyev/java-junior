package com.acme.edu.accumulator;

import com.acme.edu.container.MessageContainer;

import java.util.ArrayList;

public interface MessageAccumulator {
    ArrayList<MessageContainer> accumulate(ArrayList<MessageContainer> messages);
}
