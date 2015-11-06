import com.acme.edu.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArrayListTest {
    ArrayList sut;
    Object dummy;

    @Before
    public void setUp() {
        sut = new ArrayList();
        dummy = new Object();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void shouldSizeIncrementedWhenElementAdded() {
        //region given
        //endregion

        //region when
        sut.add(dummy);
        //endregion

        //region then
        assertEquals(1, sut.size());
        //endregion
    }

    @Test
    public void shouldToStringContainsElementsToString() {
        //region given
        ArrayList sut = new ArrayList();
        Object stub = mock(Object.class);
        when(stub.toString()).thenReturn("test string");
        sut.add(stub);
        //endregion

        //region when + then
        assertEquals("[test string]", sut.toString());
        //endregion
    }

    @Test
    public void shouldPrint() {
        LoggerPrinter mock = mock(LoggerPrinter.class);
        LoggerState sut = new IntLoggerState(mock);

        sut.log(5);
        sut.log(5);

//        verify(mock, times(1)).print("primitive: 10");
    }


    @Test(expected = DiviziobByZeroException.class)
    public void shouldErrorWhenErrorData() throws DiviziobByZeroException {
        Calc calc = new Calc();
        calc.divide(1, 0);
    }
}


















