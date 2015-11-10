package com.acme.edu.unit.PrinterTest;

import com.acme.edu.printer.ConsolePrinter;
import com.acme.edu.printer.FilePrinter;
import com.acme.edu.printer.PrinterException;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.io.FileUtils.readFileToString;
import static org.junit.Assert.assertEquals;

/**
 * Created by Павел on 07.11.2015.
 */
public class FileAndConsolePrinterTest  implements SysoutCaptureAndAssertionAbility{
    static final String SEP = System.lineSeparator();
    private FilePrinter sut;
    private String fileName = "out.txt";
    private String encoding = "UTF-8";

    @Before
    public void setUp() throws IOException, PrinterException {
        File file = new File(fileName);
        file.delete();
    }

    @Test
    public void shouldPrintStringToFile() throws PrinterException, IOException {
        //region
        String dummy = "test string";
        List<String> listMessages = new ArrayList<>();
        sut = new FilePrinter(fileName, encoding);
        //endregion

        //region when
        for (int i = 0; i < 50; i++) {
            sut.print(dummy);
            listMessages.add(dummy + SEP);
        }
        //endregion

        //region then
        assertEquals(listMessages.toString(), readFileToString(new File(fileName)));
        //endregion
    }
    @Test
    public void shouldPrintStringToConsole() throws PrinterException, IOException {
        //region
        captureSysout();
        String dummy = "test string";
        ConsolePrinter sut = new ConsolePrinter();
        //endregion

        //region when
        sut.print(dummy);
        //endregion

        //region then
        assertSysoutEquals(dummy +SEP);
        //endregion
    }


    @Test (expected = PrinterException.class)
    public void shouldLogPrinterExceptionWhenFileUnsupportedEncoding() throws PrinterException {
        //region
        sut = new FilePrinter(fileName, "???");
        String dummy = "test string";
        //endregion

        //region when
        for (int i = 0; i < 50; i++) {
            sut.print(dummy);
        }
        //endregion
    }


}
