
package com.acme.edu.api;


import com.acme.edu.Logger;
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
        final NullPointerException exception = Assertions.assertThrows
                (NullPointerException.class,
                        () -> service.log(new StringMessage(nullString)));
        logger.log(nullString);
        assertThat(exception);
        assertEquals(exception.getMessage(), "You try to write a Null String");
    }

    @Test
    public void testNullStringArray() {
        final String[] nullStringArray = {null, "2"};
        final NullPointerException exception = Assertions.assertThrows
                (NullPointerException.class,
                        () -> service.log(new StringMessage(nullStringArray[0])));
        logger.log(nullStringArray);
        assertThat(exception);
    }

    @Test
    public void testNullArray() {
        final int[] nullArray = null;
        final NullPointerException exception = Assertions.assertThrows
                (NullPointerException.class,
                        () -> service.log(new PrimitiveArrayMessage(nullArray)));

        logger.log(true, nullArray);
        assertThat(exception);
        logger.log(nullArray);
        assertThat(exception);
        assertEquals(exception.getMessage(), "You try to write a Null Array");
    }

    @Test
    public void testNullMatrix() {
        final int[][] nullMatrix = null;
        final NullPointerException exception = Assertions.assertThrows
                (NullPointerException.class,
                        () -> service.log(new PrimitiveMatrixMessage(nullMatrix)));
        logger.log(nullMatrix);
        assertThat(exception);
        logger.log(true, nullMatrix);
        assertThat(exception);
        assertEquals(exception.getMessage(), "You try to write a Null Matrix");
    }
}
