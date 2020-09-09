package unit.tests;


import com.acme.edu.ILogMessage;
import com.acme.edu.ILogPrinter;
import com.acme.edu.IntMessage;
import com.acme.edu.LogMessageController;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class MessageConrollerTests {
    LogMessageController sut;


    @Before // @After | @BeforeClass @AfterClass
    public void setUp() {
        Object mockPrinter = mock(Object.class);
    }

    @Test
    public void test1() {
        ILogPrinter mock = mock(ILogPrinter.class); // ILogPrinter
        sut = new LogMessageController(mock);

        sut.flush();

        verify(mock).print();
//        verify(mock, times(1)).toString(any());
    }

    @Test
    public void test2() {
        ILogPrinter mockPrinter = mock(ILogPrinter.class); // ILogPrinter
        ILogMessage mockMessage = mock(ILogMessage.class); // ILogMessage
        ILogMessage mockMessage2 = mock(ILogMessage.class); // ILogMessage

        sut = new LogMessageController(mockPrinter);



        when(mockMessage.IsSameType(mockMessage2))
                .thenReturn(true).thenReturn(false);

        sut.log(mockMessage);

    }

}


