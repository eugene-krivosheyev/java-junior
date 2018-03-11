package com.acme.edu.message;

import com.acme.edu.formatters.PrefixFormatter;

public interface Message {
    void accumulate();
    String isUsed();
    void flush();
    String acceptPrefix(PrefixFormatter prefixFormatter);
}