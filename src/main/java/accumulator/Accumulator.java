package accumulator;

import message.Message;

import java.util.Objects;

public interface Accumulator {

    static boolean isNewAccumulatorType(Class<?> class1, Class<?> class2) {
        return !Objects.equals(class1.getCanonicalName(), class2.getCanonicalName());
    }

    String getBody();

    String[] extractUnpromtLines();

    void accumulate(Message message);
}
