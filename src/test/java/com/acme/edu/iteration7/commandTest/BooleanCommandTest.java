package com.acme.edu.iteration7.commandTest;

import com.acme.edu.command.BooleanCommand;
import com.acme.edu.command.Command;
import com.acme.edu.command.IntCommand;
import com.acme.edu.command.NoneCommand;
import com.acme.edu.saver.ConsoleLoggerSaver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class BooleanCommandTest {
    private Object stub = mock(ConsoleLoggerSaver.class);
    private ConsoleLoggerSaver saver = new ConsoleLoggerSaver();

    @Before
    public void setUpObjects(){
    }

    @Test(expected = NullPointerException.class)
    public void shouldDownWhenNullSaver() throws IOException {
        Command sut = new BooleanCommand(true);

        sut.flush();
    }

    @Test
    public void shouldGetRightPrevCommandWhenBooleans() throws IOException {
        Command sut1 = new BooleanCommand(true);
        Command sut2 = new BooleanCommand(true);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldGetRightPrevCommandWhenOtherType() throws IOException {
        Command sut1 = new BooleanCommand(true);
        Command sut2 = new IntCommand(1);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldGetRightPrevCommandWhenNone() throws IOException {
        Command sut1 = new NoneCommand();
        Command sut2 = new BooleanCommand(true);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldDecorateBoolMessageWhenMessageDecorate(){
        Command sut = new BooleanCommand(true);
        String result = sut.messageDecorate();

        Assert.assertEquals(result,"primitive: true");
    }

}
