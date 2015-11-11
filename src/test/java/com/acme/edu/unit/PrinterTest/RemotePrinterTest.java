package com.acme.edu.unit.PrinterTest;

import com.acme.edu.printer.PrinterException;
import com.acme.edu.printer.RemotePrinter;
import com.acme.edu.server.Server;
import com.acme.edu.server.ServerException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.io.FileUtils.readFileToString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by Павел on 07.11.2015.
 */
@Ignore
public class RemotePrinterTest {
    static final String SEP = System.lineSeparator();
    private Server mock;
    private RemotePrinter sut;
    private String fileName;
    private File file;
    Server server;

    @Before
    public void setUp() throws IOException, PrinterException, ServerException {
        sut = new RemotePrinter("127.0.0.1",6666);
        mock = mock(Server.class);
        fileName = "serverOut.txt";
        file = new File(fileName);
        file.delete();

        server = new Server(6666,"UTF-8");
        Thread thread = new Thread(server);
        thread.start();
    }

    @Test
    public void shouldPrintToFileRemote() throws IOException, PrinterException, ServerException, InterruptedException {
        //region
        List<String> listMessages = new ArrayList<>();
        String dummy = "test string";
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
}
