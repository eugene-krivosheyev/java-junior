package com.acme.edu.messages;

import static com.acme.edu.messages.MessageType.CHARACTER;

public class CharacterMessage extends Message {
    public CharacterMessage(char value) {
        super.prefix = CHARACTER.getPrefix();
        super.value = String.valueOf(value);
    }
}
