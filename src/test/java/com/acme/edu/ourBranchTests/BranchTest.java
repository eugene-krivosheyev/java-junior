package com.acme.edu.ourBranchTests;


import com.acme.edu.*;
import com.acme.edu.message.Message;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.FileSaver;
import com.acme.edu.saver.ParameterCheckingSaver;
import com.acme.edu.saver.Saver;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.io.PrintWriter;

public class BranchTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test @Ignore
    public void shouldCorrectLogEmptyString()throws IOException {
        Logger.log("");
        Logger.flush();

        assertSysoutContains("(x1)");
    }


    @Test @Ignore
    public void shouldLogTwoIntegers() throws IOException {
        //region when
        Logger.log(1);
        Logger.log(2);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: 3");
        //endregion
    }

    @Test @Ignore
    public void shouldLogTwoDifferentTypes() throws IOException {
        //region when
        Logger.log(1);
        Logger.log("2");
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: 1");
        assertSysoutContains("string: 2");
        //endregion
    }


    @Test (expected = LogException.class) @Ignore
    public void saverNullStringTest() throws IOException, LogException {
        //region given
        Saver saver = new ParameterCheckingSaver();
        String testString = null;
        //endregion

        //region when
        saver.save(testString);
        //endregion

    }

    @Test @Ignore
    public void shouldNotFlushBeforeLog()throws IOException {
        int exception = Logger.flush();

        assertThat(exception).isEqualTo(1002);
    }

    @Test @Ignore
    public void saverNotNullStringTest() throws IOException, LogException {
        //region given
        Saver saver = new ParameterCheckingSaver();
        //endregion

        //region when
        saver.save("Test");
        //endregion

        //region then
        assertSysoutEquals("");
        //endregion
    }

    @Test (expected = LogException.class) @Ignore
    public void consoleSaverNullStringTest() throws IOException, LogException {
        //region given
        Saver saver = new ConsoleSaver();
        String testString = null;
        //endregion

        //region when
        saver.save(testString);
        //endregion
    }

    @Test @Ignore
    public void consoleSaverNotNullStringTest() throws IOException, LogException {
        //region given
        Saver saver = new ConsoleSaver();
        String testString = "test";
        //endregion

        //region when
        saver.save(testString);
        //endregion

        //region then
        assertSysoutEquals("test" + System.lineSeparator());
        //endregion
    }


    @Test (expected = LogException.class) @Ignore
    public void controllerFlushFunctionWhenNullMessageTest() throws IOException, LogException {
        Saver mock = mock(ParameterCheckingSaver.class);
        Controller controller = new Controller(mock);

        controller.flush();

        verify(mock, times(0)).save(null);
    }

    @Test @Ignore
    public void controllerFlushFunctionWhenNotNullMessageTest() throws IOException, LogException {
        Saver mock = mock(ParameterCheckingSaver.class);
        Message stub = mock(Message.class);
        when(stub.decorate()).thenReturn("test");
        Controller controller = new Controller(mock, stub);

        controller.flush();

        verify(mock, times(1)).save("test");
    }

    @Test @Ignore
    public void controllerLogFunctionWhenNullCurrentMessageTest() throws IOException, LogException {
        Saver mock = mock(ParameterCheckingSaver.class);
        Message stub = mock(Message.class);
        Controller controller = new Controller(mock);

        controller.log(stub);

        assertThat(controller.getCurrentMessage()).isEqualTo(stub);
    }

    @Test @Ignore
    public void controllerLogFunctionWhenNotNullCurrentMessageWithChangedTypesTest() throws IOException, LogException {
        Saver mock = mock(ParameterCheckingSaver.class);
        Message stub = mock(Message.class);
        when(stub.decorate()).thenReturn("test");
        Controller controller = new Controller(mock, stub);
        Message logMessageStub = mock(Message.class);
        when(logMessageStub.isSameType(stub)).thenReturn(false);


        controller.log(logMessageStub);

        verify(mock, times(1)).save("test");
        verify(stub, times(1)).decorate();
        assertThat(controller.getCurrentMessage()).isEqualTo(logMessageStub);
    }

    @Test @Ignore
    public void controllerLogFunctionWhenNotNullCurrentMessageWithoutChangedTypesTest() throws IOException, LogException {
        Saver mock = mock(ParameterCheckingSaver.class);
        Message stub = mock(Message.class);
        Controller controller = new Controller(mock, stub);
        Message logMessageStub = mock(Message.class);
        when(logMessageStub.isSameType(stub)).thenReturn(true);
        when(logMessageStub.accumulate(stub)).thenReturn(logMessageStub);

        controller.log(logMessageStub);

        verify(logMessageStub, times(1)).accumulate(stub);
        assertThat(controller.getCurrentMessage()).isEqualTo(logMessageStub);
    }

    @Test (expected = LogException.class)
    public void fileSaverSaveFunctionShouldNotLogNullStringTest() throws IOException, LogException {
        PrintWriter mock = mock(PrintWriter.class);
        FileSaver saver  = new FileSaver(mock);

        saver.save(null);

        verify(mock, times(0)).flush();
    }

    @Test
    public void fileSaverSaveFunctionShouldLogNotNullStringTest() throws IOException, LogException {
        PrintWriter mock = mock(PrintWriter.class);
        FileSaver saver  = new FileSaver(mock);

        saver.save("test");

        verify(mock, times(1)).println("test");
        verify(mock, times(1)).flush();
    }

}
