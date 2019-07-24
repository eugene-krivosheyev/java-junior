package com.acme.edu.iteration7.commandTest;

import com.acme.edu.command.*;
import com.acme.edu.saver.ConsoleLoggerSaver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class StringCommandTest {
    private Object stub = mock(ConsoleLoggerSaver.class);
    private ConsoleLoggerSaver saver = new ConsoleLoggerSaver();

    @Before
    public void setUpObjects(){
    }

    @Test(expected = NullPointerException.class)
    public void shouldDownWhenNullSaver() throws IOException {
        Command sut = new StringCommand("string 1");

        sut.flush();
    }

    @Test
    public void shouldGetRightPrevCommandWhenInt() throws IOException {
        Command sut1 = new StringCommand("string 1");
        Command sut2 = new StringCommand("string 2");
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldGetRightPrevCommandWhenOtherType() throws IOException {
        Command sut1 = new StringCommand("string 1");
        Command sut2 = new BooleanCommand(false);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldGetRightPrevCommandWhenNone() throws IOException {
        Command sut1 = new NoneCommand();
        Command sut2 = new StringCommand("string 1");
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldDecorateIntMessageWhenMessageDecorate(){
        Command sut = new StringCommand("string 1");
        String result = sut.messageDecorate();

        Assert.assertEquals(result,"string 1");
    }

    @Test
    public void shouldDecorateIntMessageWhenMessageDecorateWithEqualsString() throws IOException {
        Command sut1 = new StringCommand("string 1");
        Command sut2 = new StringCommand("string 1");
        sut1.accumulate(sut2,saver);
        String result = sut1.messageDecorate();

        Assert.assertEquals(result,"string 1 (x2)");
    }


    @Test
    public void shouldntAccumulateWhenDifferentTypes() throws IOException {
        Command dummy1 = new StringCommand("string 1");
        Command dummy2 = new IntCommand(-10);
        dummy1.accumulate(dummy2,saver);

        Assert.assertEquals("string 1",dummy1.messageDecorate());
    }
}
