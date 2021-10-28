package accumulator;

import message.Message;

import java.io.Serializable;
import java.util.Objects;

public interface Accumulator extends Serializable {

    default boolean isNewAccumulatorType(Class<?> classEntity) {
        return !Objects.equals(this.getClass().getCanonicalName(), classEntity.getCanonicalName());
    }

    String getBody();

    String[] extractUnpromtLines();

    void accumulate(Message message);
}
