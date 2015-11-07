package com.acme.edu.unit.PrinterTest;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.printer.PrinterException;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Павел on 07.11.2015.
 */
public class ConsolePrinterTest implements SysoutCaptureAndAssertionAbility {
    private ConsolePrinter sut;

    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldWhen() throws PrinterException, IOException {
        //region
        String dummy = "test string";
        sut = mock(ConsolePrinter.class);
        //endregion

        //region when
        sut.print(dummy);
        sut.print(dummy);
        //endregion

        //region then
        verify(sut, times(2)).print(dummy);
        //endregion
    }


}
