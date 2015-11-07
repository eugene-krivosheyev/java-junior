package com.acme.edu.unit.PrinterTest;

import com.acme.edu.printer.FilePrinter;
import com.acme.edu.printer.PrinterException;
import com.acme.edu.states.LoggerState;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.apache.commons.io.FileUtils.readFileToString;

/**
 * Created by Павел on 07.11.2015.
 */
public class FilePrinterTest {
    private FilePrinter sut;
    private String fileName = "out.txt";
    private String encoding = "UTF-8";

    @Before
    public void setUp() throws IOException, PrinterException {
        File file = new File(fileName);
        file.delete();
    }

    @Test
    public void shouldWhen() throws PrinterException, IOException {
        //region
        String dummy = "test string";
        StringBuilder sb = new StringBuilder();
        sut = new FilePrinter(fileName, encoding);
        //endregion

        //region when
        for (int i = 0; i < 100; i++) {
            sut.print(dummy);
            sb.append(dummy + LoggerState.SEP);
        }
        sut.closeStream();
        //endregion

        //region then
        assertEquals(sb.toString(), readFileToString(new File("out.txt")));
        //endregion
    }
}
