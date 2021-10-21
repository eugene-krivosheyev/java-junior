package message;

import buffer.Buffer;

public interface Message {
    Object getBody();
    Buffer getBuffer();
}
