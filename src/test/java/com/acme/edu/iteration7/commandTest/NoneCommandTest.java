package com.acme.edu.iteration7.commandTest;

import com.acme.edu.Type;
import com.acme.edu.command.BooleanCommand;
import com.acme.edu.command.Command;
import com.acme.edu.command.IntCommand;
import com.acme.edu.command.NoneCommand;
import com.acme.edu.saver.ConsoleLoggerSaver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class NoneCommandTest {
    private Object stub = mock(ConsoleLoggerSaver.class);
    private ConsoleLoggerSaver saver = new ConsoleLoggerSaver();

    @Before
    public void setUpObjects(){
    }

    @Test
    public void shouldGetRightPrevCommandWhenNone() throws IOException {
        Command sut1 = new NoneCommand();
        Command sut2 = new BooleanCommand(true);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldDecorateNoneMessageWhenMessageDecorate() {
        Command dummy1 = new NoneCommand();
        String result = dummy1.messageDecorate();

        Assert.assertEquals(result,null);
    }
}
