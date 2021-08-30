package com.acme.edu.unit;

import com.acme.edu.message.EmptyMessage;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.SaveException;
import com.acme.edu.saver.Saver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConsoleSaverTest {

    private Saver saver;

    //region given
    @BeforeEach
    void setup() {
        saver = new ConsoleSaver();
    }

    @Test
    public void shouldThrowExceptionWhenTryingToLogNullMessage() {
        EmptyMessage emptyMessage = new EmptyMessage();

        assertThrows(SaveException.class, () -> saver.save(emptyMessage.getDecoratedMessage()));
    }
}
