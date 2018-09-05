package com.acme.edu.message;

import java.util.HashMap;
import java.util.Map;

public class MessageTypes {
   private MessageTypes() {}
    public static final Map<String, Class> TYPES = new HashMap<String, Class>()
    {
        {
            put(IntMessage.class.getName(), IntMessage.class);
            put(StringMessage.class.getName(), StringMessage.class);
            put(BoolMessage.class.getName(), BoolMessage.class);
            put(ByteMessage.class.getName(), ByteMessage.class);
            put(CharMessage.class.getName(), CharMessage.class);
        }
    };
}
