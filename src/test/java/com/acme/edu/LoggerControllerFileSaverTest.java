package com.acme.edu;

import com.acme.edu.Logger;
import com.acme.edu.exception.FlushException;
import com.acme.edu.exception.LogException;
import com.acme.edu.exception.SaverException;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;
import com.acme.edu.saver.FileSaver;
import com.acme.edu.saver.Saver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.*;

public class LoggerControllerFileSaverTest {
    private File testFileLog;
    private LoggerController loggerController;

    @Before
    public void setUpSystemOut() {
        testFileLog = new File("log.txt");
        testFileLog.delete();
        loggerController = new LoggerController(new FileSaver("log.txt"));
    }

    @After
    public void tearDown() {
        //testFileLog.delete();
    }

    @Test
    public void shouldSaveInFileWhenMessageTypeIsDifferent() throws LogException, FlushException {
        Message stringMessage= new StringMessage("ololo");
        loggerController.log(stringMessage);
        Message intMessage = new IntMessage(2);
        loggerController.log(intMessage);
        IntMessage intMessage2 = new IntMessage(3);
        loggerController.log(intMessage2);
        loggerController.flush();
        assertThat(linesOf(new File("log.txt"))).containsExactly(
                "string: ololo",
                "primitive: 5"
        );
    }
}
