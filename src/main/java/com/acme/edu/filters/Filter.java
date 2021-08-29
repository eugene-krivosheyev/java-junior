package com.acme.edu.filters;

import com.acme.edu.messages.Message;

public interface Filter {
    boolean filter(Message message);
}
