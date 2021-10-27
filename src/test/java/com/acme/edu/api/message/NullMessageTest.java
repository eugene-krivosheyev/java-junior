
package com.acme.edu.api.message;


import com.acme.edu.Logger;
import com.acme.edu.api.LoggerController;
import com.acme.edu.api.message.ObjectRefMessage;
import com.acme.edu.api.message.PrimitiveArrayMessage;
import com.acme.edu.api.message.PrimitiveMatrixMessage;
import com.acme.edu.api.message.StringMessage;
import com.acme.edu.api.saver.Saver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.fest.assertions.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class NullMessageTest {
    final Saver saver = mock(Saver.class);
    final LoggerController service = new LoggerController(saver);
    final Logger logger = mock(Logger.class);

    @Test
    public void testNullString() {
        final String nullString = null;
        final IllegalArgumentException exception = Assertions.assertThrows
                (IllegalArgumentException.class,
                        () -> service.log(new StringMessage(nullString)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> logger.log(nullString));
        assertEquals(exception.getMessage(), "You try to write a Null String");
    }

    @Test
    public void testNullStringArray() {
        final String[] nullStringArray = {null, "2"};
        final IllegalArgumentException exception = Assertions.assertThrows
                (IllegalArgumentException.class,
                        () -> service.log(new StringMessage(nullStringArray[0])));
        Assertions.assertThrows(IllegalArgumentException.class, () -> logger.log(nullStringArray));
    }

    @Test
    public void testNullArray() {
        final int[] nullArray = null;
        final IllegalArgumentException exception = Assertions.assertThrows
                (IllegalArgumentException.class,
                        () -> service.log(new PrimitiveArrayMessage(nullArray)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> logger.log(nullArray));
        Assertions.assertThrows(IllegalArgumentException.class, () -> logger.log(true, nullArray));
        assertEquals(exception.getMessage(), "You try to write a Null Array");
    }

    @Test
    public void testNullMatrix() {
        final int[][] nullMatrix = null;
        final IllegalArgumentException exception = Assertions.assertThrows
                (IllegalArgumentException.class,
                        () -> service.log(new PrimitiveMatrixMessage(nullMatrix)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> logger.log(nullMatrix));
        Assertions.assertThrows(IllegalArgumentException.class, () -> logger.log(true, nullMatrix));
        assertEquals(exception.getMessage(), "You try to write a Null Matrix");
    }

    @Test
    public void testNullObject() {
        final Object object = null;
        final IllegalArgumentException exception = Assertions.assertThrows
                (IllegalArgumentException.class,
                        () -> service.log(new ObjectRefMessage(object)));
        assertEquals(exception.getMessage(), "You try to write a Null Object");
    }
}
