package com.acme.edu.unit;

import com.acme.edu.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Павел on 04.11.2015.
 */
public class LoggerTest {
    private Factory factory;
    private Printer printer;
    private Logger sut;
    private IntState intState;
    private StringState stringState;
    private SimplePrintState simplePrintState;

    @Before
    public void setUp() throws IOException {
        printer = mock(Printer.class);
        intState = mock(IntState.class);
        simplePrintState = mock(SimplePrintState.class);
        stringState = mock(StringState.class);

        factory = new Factory(intState, stringState, simplePrintState);
        sut = new Logger(printer, factory);
    }

    @Test
    public void shouldLogCountOfCallsWhenSetOtherState() {

        //region given
        factory.setSimplePrintState();
        //endregion

        //region when
        sut.log("str 1", "str 2");
        sut.log(new int[]{1, 2, 3});
        sut.log("string 1");
        sut.log(1);
        sut.log(1);
        //region end

        //region then
        factory.setSimplePrintState();
        verify(factory.loggerState, times(1)).log("str 1", "str 2");
        verify(factory.loggerState, times(1)).log(new int[]{1, 2, 3});
        factory.setStringState();
        verify(factory.loggerState, times(1)).log("string 1");
        factory.setIntState();
        verify(factory.loggerState, times(2)).log("1");
        //region end

    }
    @Test
    public void shouldLogCountOfCallsWhenSetIntState() {

        //region when
        sut.log("str 1");
        sut.log("str 1");
        sut.log("str 1");
        //endregion

        //region then
        verify(factory.loggerState, times(3)).log("str 1");
        //endregion
    }
}
