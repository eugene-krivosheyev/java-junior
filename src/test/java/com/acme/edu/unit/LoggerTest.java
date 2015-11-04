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

    private Printer printerMock;
    private Logger logger;
    private LoggerState loggerState;
    private static final String SEP = System.lineSeparator();

    //region given
    @Before
    public void setUp() throws IOException {
        printerMock = mock(Printer.class);

    }

    @Test
    public void shouldLogSequentWhenPrintSum() {

        //region given
        loggerState = new IntState(printerMock);
        //endregion

        //region when + then
        loggerState.log("1");
        loggerState.log("0");
        loggerState.log("-1");
        loggerState.flush();

        verify(printerMock).print("primitive: 0");
        //endregion
    }

    @Test
    public void shouldLogIntegerMinAndMaxWhenPrintIntegerMinAndMax() {

        //region given
        loggerState = new IntState(printerMock);
        //endregion

        //region when
        loggerState.log("1");
        loggerState.log(String.valueOf(Integer.MAX_VALUE));
        loggerState.log(String.valueOf(Integer.MIN_VALUE));
        loggerState.flush();
        loggerState.log(String.valueOf(Integer.MAX_VALUE - 10));
        loggerState.log(String.valueOf(11));
        loggerState.flush();
        loggerState.log(String.valueOf(Integer.MIN_VALUE + 10));
        loggerState.log(String.valueOf(-11));
        loggerState.flush();
        //endregion

        //region then
        verify(printerMock).print("primitive: " + 1);
        verify(printerMock).print("primitive: " + Integer.MAX_VALUE);
        verify(printerMock).print("primitive: " + Integer.MIN_VALUE);
        verify(printerMock).print("primitive: " + String.valueOf(Integer.MAX_VALUE - 10));
        verify(printerMock).print("primitive: " + 11);
        verify(printerMock).print("primitive: " + String.valueOf(Integer.MIN_VALUE + 10));
        verify(printerMock).print("primitive: " + -11);
        //endregion
    }

    @Test
    public void shouldLogStringWhenPrintCountDuplicateString() {

        //region given
        loggerState = new StringState(printerMock);
        //endregion

        //region when
        loggerState.log("str 1");
        loggerState.log("str 2");
        loggerState.log("str 2");
        loggerState.log("str 2");
        loggerState.log("str 4");
        loggerState.log("str 3");
        loggerState.log("str 3");
        loggerState.flush();
        //endregion

        //region then
        verify(printerMock).print("string: str 1");
        verify(printerMock).print("string: str 2 (x3)");
        verify(printerMock).print("string: str 4");
        verify(printerMock).print("string: str 3 (x2)");
        //endregion
    }

    @Test
    public void shouldEmptyStringWhenPrintEmpty() {

        //region given
        loggerState = new StringState(printerMock);
        //endregion

        //region when
        loggerState.log("str 1");
        loggerState.log();
        loggerState.log("str 2");
        loggerState.flush();
        //endregion

        //region then
        verify(printerMock).print("string: str 1");
        verify(printerMock).print("string: str 2");

        //endregion
    }

    @Test
    public void shouldLogArrayAndMatrixWhenPrintArrayAndMatrix() {

        //region given
        loggerState = new SimplePrintState(printerMock);
        //endregion

        //region when
        loggerState.log(new int[] {-1, 0, 1});
        loggerState.log(new int[] {-1, 0, 1, 3});
        loggerState.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        loggerState.log(new int[][][][] {{{{0}}}});
        //endregion

        //region then
        verify(printerMock).print("primitives array: {-1, 0, 1}");
        verify(printerMock).print("3");
        verify(printerMock).print("primitives matrix: {" + SEP +
                "{-1, 0, 1}" + SEP +
                "{1, 2, 3}" + SEP +
                "{-1, -2, -3}" + SEP +
                "}");
        verify(printerMock).print("primitives multimatrix: {" + SEP +
                "{"+ SEP + "{"+ SEP + "{"+ SEP +
                "0" + SEP +
                "}"+ SEP + "}"+ SEP + "}"+ SEP +
                "}");

        //endregion
    }

    @Test
    public void shouldLogVarArgWhenPrintVarArg() {

        //region given
        loggerState = new SimplePrintState(printerMock);
        //endregion

        //region when
        loggerState.log("str1", "string 2", "str 3", "", "string 5");

        //endregion

        //region then
        verify(printerMock).print("str1");
        verify(printerMock).print("string 2");
        verify(printerMock).print("str 3");
        verify(printerMock).print("string 5");

        //endregion
    }


    /*
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
    */
}
