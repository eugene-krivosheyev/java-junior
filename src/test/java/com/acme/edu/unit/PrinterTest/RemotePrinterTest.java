package com.acme.edu.unit.PrinterTest;

import com.acme.edu.Server.Server;
import com.acme.edu.Server.ServerException;
import com.acme.edu.printer.PrinterException;
import com.acme.edu.printer.RemotePrinter;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.apache.commons.io.FileUtils.readFileToString;

/**
 * Created by Павел on 07.11.2015.
 */
@Ignore
public class RemotePrinterTest {
    static final String SEP = System.lineSeparator();
    private Server sutServer;
    private RemotePrinter remotePrinter;
    private String fileName = "out.txt";

    @Before
    public void setUp() throws IOException, PrinterException, ServerException {
        File file = new File(fileName);
        file.delete();
        sutServer = new Server(6666);
        sutServer.startServer();
    }

    @Test
    public void shouldPrintToFileRemote() throws IOException, PrinterException {
        //region
        String dummy = "test string";
        StringBuilder sb = new StringBuilder();
        remotePrinter = new RemotePrinter("127.0.0.1", 6666);
        //endregion

        //region when
        for (int i = 0; i < 51; i++) {
            sb.append(dummy + SEP);
            remotePrinter.print(dummy);
        }
        //endregion

        //region then
        assertEquals(sb.toString(), readFileToString(new File("serverOut.txt")));
        //endregion
    }
}
