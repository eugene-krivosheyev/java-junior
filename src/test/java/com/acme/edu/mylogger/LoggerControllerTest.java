package com.acme.edu.mylogger;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.mylogger.accumulators.SuperAccumulator;
import com.acme.edu.mylogger.accumulators.SuperCurrentAccumulator;
import com.acme.edu.mylogger.commands.IntCommand;
import com.acme.edu.mylogger.savers.SuperConsoleSaver;
import com.acme.edu.mylogger.savers.SuperSaver;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class LoggerControllerTest implements SysoutCaptureAndAssertionAbility {
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test @Ignore
    public void shouldAccumulateCommandWhenSameIntTypeCommand() throws ReflectiveOperationException {
        SuperAccumulator dummyAccumulator = mock(SuperCurrentAccumulator.class);
        SuperSaver mockSaver = mock(SuperConsoleSaver.class);

        IntCommand firstStubCommand = mock(IntCommand.class);
        when(firstStubCommand.isTypeEquals(null)).thenReturn(false);

        IntCommand secondStubCommand = mock(IntCommand.class);
        IntCommand thirdStubCommand = mock(IntCommand.class);
        when(secondStubCommand.isTypeEquals(null)).thenReturn(false);
        when(secondStubCommand.isTypeEquals(firstStubCommand)).thenReturn(true);
        when(firstStubCommand.getMessage()).thenReturn(1);
        when(secondStubCommand.getMessage()).thenReturn(2);
        when(firstStubCommand.accumulate(secondStubCommand)).thenReturn(thirdStubCommand);
        when(thirdStubCommand.isOverflow()).thenReturn(false);

        final LoggerController sut = new LoggerController(dummyAccumulator, mockSaver);

        sut.log(firstStubCommand);
        sut.log(secondStubCommand);
        sut.flush();

        //Interaction-based testing:
        verify(firstStubCommand).isTypeEquals(null);
        verify(secondStubCommand).isTypeEquals(firstStubCommand);
    }

    @Test(expected = ArithmeticException.class) @Ignore
    public void shouldThrowArithmeticExceptionWhenOverflow() {
        final SuperCurrentAccumulator superCurrentAccumulator = new SuperCurrentAccumulator();
        final SuperConsoleSaver superConsoleSaver = new SuperConsoleSaver();
        final LoggerController loggerController = new LoggerController(superCurrentAccumulator, superConsoleSaver);
        loggerController.log(new IntCommand(1));
        loggerController.log(new IntCommand(Integer.MAX_VALUE));
        loggerController.flush();
    }
}
