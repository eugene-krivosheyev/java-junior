package com.acme.edu.unit.PrinterTest;

import com.acme.edu.server.Server;
import com.acme.edu.server.ServerException;
import com.acme.edu.printer.PrinterException;
import com.acme.edu.printer.RemotePrinter;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

import static org.apache.commons.io.FileUtils.readFileToString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Павел on 07.11.2015.
 */
@Ignore
public class RemotePrinterTest {
    static final String SEP = System.lineSeparator();
    private Server mock;
    private RemotePrinter sut;
    private ServerSocket serverSocket;
    private String fileName = "out.txt";

    @Before
    public void setUp() throws IOException, PrinterException, ServerException {
        sut = new RemotePrinter("127.0.0.1",6666);
        mock = mock(Server.class);
        when(mock.getServerSocket()).thenReturn(new ServerSocket(6666));
        File file = new File(fileName);
        file.delete();

    }

    @Test
    public void shouldPrintToFileRemote() throws IOException, PrinterException, ServerException, InterruptedException {
        //region
        String dummy = "test string";
        Thread thread = new Thread(new Server(6666));
        thread.start();
        //endregion

        //region when
        Thread.sleep(2000);
            sut.print(dummy);
        //endregion

        //region then

        assertEquals("", readFileToString(new File("serverOut.txt")));
        //endregion
    }
}
