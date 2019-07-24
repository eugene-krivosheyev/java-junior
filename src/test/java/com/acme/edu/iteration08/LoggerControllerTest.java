package com.acme.edu.iteration08;

import com.acme.edu.Logger;
import com.acme.edu.LoggerController;
import com.acme.edu.command.ByteCommand;
import com.acme.edu.command.IntCommand;
import com.acme.edu.exceptions.EmptySaverException;
import com.acme.edu.saver.ConsoleLoggerSaver;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import java.io.IOException;

public class LoggerControllerTest {

    @Test(expected = EmptySaverException.class)
    public void mustThrowESE() throws EmptySaverException, IOException {
        LoggerController loggerController = new LoggerController(null);
        loggerController.log(new IntCommand(1));
    }

    @Test
    public void  shoudntDownWhenNoneCommand() throws IOException{
        LoggerController loggerController = new LoggerController(new ConsoleLoggerSaver());
        loggerController.flush();
    }


}
