package com.acme.edu.iteration7.commandTest;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.command.*;
import com.acme.edu.saver.ConsoleLoggerSaver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class ByteCommandTest implements SysoutCaptureAndAssertionAbility {
    private Object stub = mock(ConsoleLoggerSaver.class);
    private ConsoleLoggerSaver saver = new ConsoleLoggerSaver();

    @Before
    public void setUpObjects(){
    }

    @Test(expected = NullPointerException.class)
    public void shouldDownWhenNullSaver() throws IOException {
        Command sut = new ByteCommand((byte)1);

        sut.flush();
    }

    @Test
    public void shouldGetRightPrevCommandWhenInt() throws IOException {
        Command sut1 = new ByteCommand((byte)1);
        Command sut2 = new ByteCommand((byte)2);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldGetRightPrevCommandWhenOtherType() throws IOException {
        Command sut1 = new ByteCommand((byte)2);
        Command sut2 = new BooleanCommand(false);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldGetRightPrevCommandWhenNone() throws IOException {
        Command sut1 = new NoneCommand();
        Command sut2 = new ByteCommand((byte)1);
        sut2.accumulate(sut1,(ConsoleLoggerSaver) stub);

        Assert.assertEquals(sut2,sut2.getPrevCommand());
    }

    @Test
    public void shouldDecorateIntMessageWhenMessageDecorate(){
        Command sut = new ByteCommand((byte)1);
        String result = sut.messageDecorate();

        Assert.assertEquals(result,"1");
    }

    @Test
    public void shouldCorrectAccumulateWhenAccumulatePositiveWithoutOverflow() throws IOException {
        Command dummy1 = new ByteCommand((byte)10);
        Command dummy2 = new ByteCommand((byte)20);
        dummy1.accumulate(dummy2,saver);

        Assert.assertEquals("30",dummy1.messageDecorate());
    }

    @Test
    public void shouldntAccumulateWhenPositiveOverflow() throws IOException {
        Command dummy1 = new ByteCommand(Byte.MAX_VALUE);
        Command dummy2 = new ByteCommand((byte)10);
        Command dummy3 = new ByteCommand((byte)20);
        dummy1.accumulate(dummy2,saver);
        dummy3.accumulate(dummy1,saver);

        Assert.assertEquals(String.valueOf(Byte.MAX_VALUE),dummy1.messageDecorate());
        Assert.assertEquals("20",dummy3.messageDecorate());
    }

    @Test
    public void shouldntAccumulateWhenNegativeOverflow() throws IOException {
        Command dummy1 = new ByteCommand(Byte.MIN_VALUE);
        Command dummy2 = new ByteCommand((byte)-10);
        Command dummy3 = new ByteCommand((byte)-20);
        dummy1.accumulate(dummy2,saver);
        dummy3.accumulate(dummy1,saver);

        Assert.assertEquals(String.valueOf(Byte.MIN_VALUE),dummy1.messageDecorate());
        Assert.assertEquals("-20",dummy3.messageDecorate());
    }

    @Test
    public void shouldCorrectAccumulateWhenAccumulateNegativeWithoutOverflow() throws IOException {
        Command dummy1 = new ByteCommand((byte)-10);
        Command dummy2 = new ByteCommand((byte)-20);
        dummy1.accumulate(dummy2,saver);

        Assert.assertEquals("-30",dummy1.messageDecorate());
    }

    @Test
    public void shouldntAccumulateWhenDifferentTypes() throws IOException {
        Command dummy1 = new ByteCommand((byte) -20);
        Command dummy2 = new IntCommand(-10);
        dummy1.accumulate(dummy2,saver);

        Assert.assertEquals("-20",dummy1.messageDecorate());
    }
}
