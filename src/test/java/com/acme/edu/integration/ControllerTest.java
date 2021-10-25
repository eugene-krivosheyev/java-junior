package com.acme.edu.integration;

import com.acme.edu.Controller;
import com.acme.edu.Flusher;
import com.acme.edu.StatesDTO;
import com.acme.edu.TypeCodeEnum;
import com.acme.edu.message.StringMessage;
import com.acme.edu.saver.SystemOutSaver;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {
    private final SystemOutSaver saverStub = mock(SystemOutSaver.class);
    private final Controller controller = new Controller(new StatesDTO(new Flusher(saverStub)), new Flusher(saverStub));

    @Test
    public void shouldFlushWhenLogTwoStringMessage() {
        StringMessage firstStringMessage = mock(StringMessage.class);
        StringMessage secondStringMessage = mock(StringMessage.class);

        when(firstStringMessage.getMessage()).thenReturn("Hello world first");
        when(secondStringMessage.getMessage()).thenReturn("Hello world again");
        when(firstStringMessage.getCode()).thenReturn(TypeCodeEnum.STRING);
        when(secondStringMessage.getCode()).thenReturn(TypeCodeEnum.STRING);

        controller.log(firstStringMessage);
        controller.log(secondStringMessage);

        verify(saverStub).save("string: Hello world first");
    }

    @Test
    @Ignore
    public void shouldSetByteSumWhenLogByte() {
        StringMessage firstStringMessage = mock(StringMessage.class);
        StringMessage secondStringMessage = mock(StringMessage.class);

        when(firstStringMessage.getMessage()).thenReturn("Hello world first");
        when(secondStringMessage.getMessage()).thenReturn("Hello world again");
        when(firstStringMessage.getCode()).thenReturn(TypeCodeEnum.STRING);
        when(secondStringMessage.getCode()).thenReturn(TypeCodeEnum.STRING);

        controller.log(firstStringMessage);
        controller.log(secondStringMessage);

        verify(saverStub).save("string: Hello world first");
    }
}
