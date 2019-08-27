package com.acme.edu.ooaddemo2;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * _UNIT_ test!!!!
 */
public class LoggerControllerTest {
    @Test
    public void shouldAccumulateCommandWhenSameIntTypeCommand() {
        SuperFilter dummyFilter = mock(SuperFilter.class);
        SuperSaver mockSaver = mock(SuperSaver.class);

        IntCommand firstStubCommand = mock(IntCommand.class);
        when(firstStubCommand.isTypeEquals(null)).thenReturn(false);
        when(firstStubCommand.getDecorated()).thenReturn("first command");

        IntCommand secondStubCommand = mock(IntCommand.class);
        when(secondStubCommand.isTypeEquals(firstStubCommand)).thenReturn(true);

        when(firstStubCommand.getMessage()).thenReturn(1);
        when(secondStubCommand.getMessage()).thenReturn(2);
        doReturn(2).when(secondStubCommand).getMessage();

        /*
        new CommandBuilder()
                .withType(INT)
                .withMessage(1)
                .withSaver()
            .build();
         */

        final LoggerController sut = new LoggerController(dummyFilter, mockSaver);

        sut.log(firstStubCommand);
        sut.log(secondStubCommand);

        //Interaction-based testing:
        verify(firstStubCommand).isTypeEquals(null);
        verify(mockSaver).save("first command");
        verify(secondStubCommand).isTypeEquals(firstStubCommand);
        verify(firstStubCommand).accumulate(secondStubCommand);

        //State-based testing: (FEST-reflect)
//        assertThat(sut.getCurrentState().getMessage())
//                .isEqualTo(3);
    }
}
