package com.acme.edu.unit.Server;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.logger.LogException;
import com.acme.edu.printer.PrinterException;
import com.acme.edu.printer.RemotePrinter;
import com.acme.edu.server.Server;
import com.acme.edu.server.ServerException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

import static junit.framework.TestCase.assertEquals;
import static org.apache.commons.io.FileUtils.readFileToString;
import static org.mockito.Mockito.mock;

/**
 * Created by Павел on 08.11.2015.
 */
@Ignore
public class serverTest extends Thread implements SysoutCaptureAndAssertionAbility {
    private static final String SEP = System.lineSeparator();
    private RemotePrinter sut;
    private ServerSocket serverSocket;
    private Server mock;
    private String fileName = "d:\\education\\serverOut.txt";
    //region given
    @Before
    public void setUp() throws PrinterException, IOException, ServerException {
        sut = new RemotePrinter("127.0.0.1", 6666, "UTF-8");
        serverSocket = mock(ServerSocket.class);
        mock = mock(Server.class);
        File file = new File(fileName);
        file.delete();

    }

    @After
    public void tearDown() throws PrinterException {
        resetOut();
    }
    //endregion

    @Test
    public void shouldLogInteger() throws LogException, IOException, PrinterException, ServerException {

        //region when
        String dummy = "test string";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 51; i++) {
            sut.print(dummy);
            sb.append(dummy + SEP);
        }
        //endregion

        //region then
        assertEquals(sb.toString(), readFileToString(new File(fileName)));
        //endregion
    }

}
