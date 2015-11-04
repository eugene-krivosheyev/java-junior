package com.acme.edu.unit;

import com.acme.edu.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;

/**
 * Created by Павел on 03.11.2015.
 */
public class LoggerTest {
    private Printer mock;
    private IntState sutIntState;
    private SimplePrintState sutSimplePrintState;
    private StringState sutStringState;

    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        mock = mock(Printer.class);
    }

    @Test
    public void shouldLogSequentWhenPrintSum() {

        //region given
        sutIntState = new IntState(mock);
        //endregion

        //region when + then
        sutIntState.log("5");
        sutIntState.log("3");
        sutIntState.log("-1");
        sutIntState.flush();

        verify(mock).print("primitive: 7");
        //endregion
    }

    @Test
    public void shouldLogIntegersArray() {

        //region given
        Printer mock = mock(Printer.class);
        sutSimplePrintState = new SimplePrintState(mock);
        //endregion

        //region when + then
        sutSimplePrintState.log(new int[]{-1, 0, 1});

        verify(mock).print("primitives array: {-1, 0, 1}");
        //endregion
    }
    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() {

        //region given
        Printer mock = mock(Printer.class);
        sutStringState = new StringState(mock);
        //endregion

        //region when + then
        sutStringState.log("str 1");
        sutStringState.log("str 1");
        sutStringState.flush();

        verify(mock).print("string: str 1 (x2)");
        //endregion
    }
}
