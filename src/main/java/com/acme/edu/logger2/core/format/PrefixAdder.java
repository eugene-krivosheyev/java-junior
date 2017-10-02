package com.acme.edu.logger2.core.format;

import com.acme.edu.logger2.core.message.Message;

/**
 * Orders messages to add prefixes into their content.
 */
public class PrefixAdder implements com.acme.edu.logger2.core.format.LoggerFormatter {
    @Override
    public void format(Message message) {
        message.addPrefix();
    }
}
