package buffer;

import message.Message;

import java.util.ArrayList;
import java.util.Objects;

public interface Buffer {

    static boolean isNewBufferType(Class<?> c1, Class<?> c2) {
        String name1 = c1.getCanonicalName();
        String name2 = c2.getCanonicalName();
        return !Objects.equals(name1, name2);
    }

    String getBody();

    ArrayList<String> getExtraordinaryBody();

    void accumulate(Message message);
}
