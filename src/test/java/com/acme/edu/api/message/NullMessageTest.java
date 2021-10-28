
package com.acme.edu.api.message;

import com.acme.edu.Logger;
import com.acme.edu.api.LoggerController;
import com.acme.edu.api.saver.ConsoleSaver;
import com.acme.edu.api.saver.Saver;
import org.junit.jupiter.api.*;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NullMessageTest{
    private Saver saver;
    private LoggerController service;

    @BeforeEach
    public void init() {
        saver = new ConsoleSaver();
        service = new LoggerController(saver);
    }

    @Test
    public void testNullString() throws NullMessageException{
        final String nullString = null;
        final NullMessageException exception = assertThrows(NullMessageException.class,
                () -> service.log(new StringMessage(nullString)));
        assertThat(exception.getMessage()).isEqualTo("You try to write a Null String");
    }

    @Test
    public void testNullArray() {
        final int[] nullArray = null;
        final NullMessageException exception = assertThrows(NullMessageException.class,
                () -> service.log(new PrimitiveArrayMessage(nullArray)));
        assertThat(exception.getMessage()).isEqualTo("You try to write a Null Array");
    }

    @Test
    public void testNullMatrix() {
        final int[][] nullMatrix = null;
        final NullMessageException exception = assertThrows(NullMessageException.class,
                () -> service.log(new PrimitiveMatrixMessage(nullMatrix)));
        assertThat(exception.getMessage()).isEqualTo("You try to write a Null Matrix");
    }

    @Test
    public void testNullObject() {
        final Object object = null;
        final NullMessageException exception = assertThrows(NullMessageException.class,
                () -> service.log(new ObjectRefMessage(object)));
        assertThat(exception.getMessage()).isEqualTo("You try to write a Null Object");
    }
}
