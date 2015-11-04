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
public class StateTest {

    private Printer printerMock;
    private LoggerState sut;
    private static final String SEP = System.lineSeparator();

    //region given
    @Before
    public void setUp() throws IOException {
        printerMock = mock(Printer.class);

    }

    @Test
    public void shouldLogSequentWhenPrintSum() {

        //region given
        sut = new IntState(printerMock);
        //endregion

        //region when + then
        sut.log("1");
        sut.log("0");
        sut.log("-1");
        sut.flush();

        verify(printerMock).print("primitive: 0");
        //endregion
    }

    @Test
    public void shouldLogIntegerMinAndMaxWhenPrintIntegerMinAndMax() {

        //region given
        sut = new IntState(printerMock);
        //endregion

        //region when
        sut.log("1");
        sut.log(String.valueOf(Integer.MAX_VALUE));
        sut.log(String.valueOf(Integer.MIN_VALUE));
        sut.flush();
        sut.log(String.valueOf(Integer.MAX_VALUE - 10));
        sut.log(String.valueOf(11));
        sut.flush();
        sut.log(String.valueOf(Integer.MIN_VALUE + 10));
        sut.log(String.valueOf(-11));
        sut.flush();
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
        sut = new StringState(printerMock);
        //endregion

        //region when
        sut.log("str 1");
        sut.log("str 2");
        sut.log("str 2");
        sut.log("str 2");
        sut.log("str 4");
        sut.log("str 3");
        sut.log("str 3");
        sut.flush();
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
        sut = new StringState(printerMock);
        //endregion

        //region when
        sut.log("str 1");
        sut.log();
        sut.log("str 2");
        sut.flush();
        //endregion

        //region then
        verify(printerMock).print("string: str 1");
        verify(printerMock).print("string: str 2");

        //endregion
    }

    @Test
    public void shouldLogArrayAndMatrixWhenPrintArrayAndMatrix() {

        //region given
        sut = new SimplePrintState(printerMock);
        //endregion

        //region when
        sut.log(new int[]{-1, 0, 1});
        sut.log(new int[]{-1, 0, 1, 3});
        sut.log(new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        sut.log(new int[][][][]{{{{0}}}});
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
        sut = new SimplePrintState(printerMock);
        //endregion

        //region when
        sut.log("str1", "string 2", "str 3", "", "string 5");

        //endregion

        //region then
        verify(printerMock).print("str1");
        verify(printerMock).print("string 2");
        verify(printerMock).print("str 3");
        verify(printerMock).print("string 5");

        //endregion
    }
}
