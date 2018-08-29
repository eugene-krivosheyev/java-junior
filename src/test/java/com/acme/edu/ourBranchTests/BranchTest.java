package com.acme.edu.ourBranchTests;


import com.acme.edu.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

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

    @Test
    public void saverNullStringTest() throws IOException {
        //region given
        Saver saver = new Saver();
        String testString = null;
        //endregion

        //region when
        saver.save(testString);
        //endregion

        //region then
        assertSysoutContains("It is null!!!!");
        //endregion
    }



    @Test
    public void saverNotNullStringTest() throws IOException {
        //region given
        Saver saver = new Saver();
        //endregion

        //region when
        saver.save("Test");
        //endregion

        //region then
        assertSysoutEquals("");
        //endregion
    }

    @Test
    public void consoleSaverNullStringTest() throws IOException {
        //region given
        Saver saver = new ConsolSaver();
        String testString = null;
        //endregion

        //region when
        saver.save(testString);
        //endregion

        //region then
        assertSysoutContains("It is null!!!!");
        assertSysoutContains("null");
        //endregion
    }
    @Test
    public void consoleSaverNotNullStringTest() throws IOException {
        //region given
        Saver saver = new ConsolSaver();
        String testString = "test";
        //endregion

        //region when
        saver.save(testString);
        //endregion

        //region then
        assertSysoutEquals("test" + System.lineSeparator());
        //endregion
    }


    @Test
    public void controllerFlushFunctionWhenNullMessageTest() throws IOException {
        Saver mock = mock(Saver.class);
        Controller controller = new Controller(mock);

        controller.flush();

        verify(mock, times(0)).save(null);
    }

    @Test
    public void controllerFlushFunctionWhenNotNullMessageTest() throws IOException {
        Saver mock = mock(Saver.class);
        Message stub = mock(Message.class);
        when(stub.decorate()).thenReturn("test");
        Controller controller = new Controller(mock, stub);

        controller.flush();

        verify(mock, times(1)).save("test");
    }

    @Test
    public void controllerLogFunctionWhenNullCurrentMessageTest() throws IOException {
        Saver mock = mock(Saver.class);
        Message stub = mock(Message.class);
        Controller controller = new Controller(mock);

        controller.log(stub);

        assertThat(controller.getCurrentMessage()).isEqualTo(stub);
    }

    @Test
    public void controllerLogFunctionWhenNotNullCurrentMessageWithChangedTypesTest() throws IOException {
        Saver mock = mock(Saver.class);
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

    @Test
    public void controllerLogFunctionWhenNotNullCurrentMessageWithoutChangedTypesTest() throws IOException {
        Saver mock = mock(Saver.class);
        Message stub = mock(Message.class);
        Controller controller = new Controller(mock, stub);
        Message logMessageStub = mock(Message.class);
        when(logMessageStub.isSameType(stub)).thenReturn(true);
        when(logMessageStub.accumulate(stub)).thenReturn(logMessageStub);

        controller.log(logMessageStub);

        verify(logMessageStub, times(1)).accumulate(stub);
        assertThat(controller.getCurrentMessage()).isEqualTo(logMessageStub);
    }


}
