package com.acme.edu.logger;

import com.acme.edu.Decorator.IntegerDecorator;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.controller.Controller;
import com.acme.edu.controller.LogOperationException;
import com.acme.edu.message.*;
import com.acme.edu.saver.SaveException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Java_1 on 28.08.2018.
 */
public class ControllerTest implements SysoutCaptureAndAssertionAbility {

    private Controller testController;

    @Before
    public void setUp() throws IOException {
        resetOut();
        captureSysout();
        testController = new Controller();
    }


    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldDoNothingWhenMessageIsNull() throws LogOperationException{
        testController.setCurrentMessage(null);
        testController.log(null);
        testController.flush();
    }

    @Test
    public void shouldLogInteger() throws LogOperationException{
        IntMessage message = mock(IntMessage.class);
        when(message.getDecoratedMessage()).thenReturn("primitive: 2");
        testController.log(message);
        testController.flush();
        assertSysoutContains("2");
    }

    @Test
    public void shouldLogIntegerAndChar() throws LogOperationException{
        IntMessage intMessage = mock(IntMessage.class);
        when(intMessage.getDecoratedMessage()).thenReturn("primitive: 2");
        CharMessage charMessage = mock(CharMessage.class);
        when(charMessage.getDecoratedMessage()).thenReturn("char: a");

        testController.log(intMessage);
        testController.log(charMessage);
        testController.flush();

        assertSysoutContains("primitive: 2");
        assertSysoutContains("char: a");
    }

    @Ignore
    @Test
    public void shouldLogAccumulateStringsAndBoolean() throws LogOperationException, SaveException{
        StringMessage firstMessage = mock(StringMessage.class);
        StringMessage secondMessage = mock(StringMessage.class);
        BooleanMessage booleanMessage = mock(BooleanMessage.class);
        //when(firstMessage.accumulate(secondMessage)).thenReturn(secondMessage);
        when(secondMessage.getDecoratedMessage()).thenReturn("test message(x2)");
        when(booleanMessage.getDecoratedMessage()).thenReturn("primitive: true");

        testController.log(firstMessage);
        testController.log(secondMessage);
        testController.log(booleanMessage);
        testController.flush();

        assertSysoutContains("test message(x2)");
        assertSysoutContains("primitive: true");
    }

    @Test
    public void shouldLogChar() throws LogOperationException{
        CharMessage message = mock(CharMessage.class);
        when(message.getDecoratedMessage()).thenReturn("char: a");
        testController.log(message);
        testController.flush();
        assertSysoutContains("a");
    }

    @Test
    public void shouldLogBoolean() throws LogOperationException{
        BooleanMessage message = mock(BooleanMessage.class);
        when(message.getDecoratedMessage()).thenReturn("primitive: true");
        testController.log(message);
        testController.flush();
        assertSysoutContains("true");
    }

    @Test
    public void shouldLogByte() throws LogOperationException{
        ByteMessage message = mock(ByteMessage.class);
        when(message.getDecoratedMessage()).thenReturn("primitive: 3");
        testController.log(message);
        testController.flush();
        assertSysoutContains("3");
    }

    @Test
    public void shouldLogString() throws LogOperationException{
        StringMessage message = mock(StringMessage.class);
        when(message.getDecoratedMessage()).thenReturn("string: test message");
        testController.log(message);
        testController.flush();
        assertSysoutContains("test message");
    }

    @Test
    public void shouldLogObject() throws LogOperationException{
        ObjectMessage message = mock(ObjectMessage.class);
        when(message.getDecoratedMessage()).thenReturn("reference: " + new Object().toString());
        testController.log(message);
        testController.flush();
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
    }

    @Ignore
    @Test
    public void shouldLogSequentIntegersAsSum() throws LogOperationException{
        IntMessage firstMessage = mock(IntMessage.class);
        IntMessage secondMessage = mock(IntMessage.class);
        IntMessage resultMessage = mock(IntMessage.class);
 //       when(firstMessage.accumulate(secondMessage)).thenReturn(resultMessage);
        when(resultMessage.getDecoratedMessage()).thenReturn("primitive: 8");
        testController.log(firstMessage);
        testController.log(secondMessage);
        testController.flush();

    }

    @Ignore
    @Test
    public void shouldLogSequentStringsWithAccumulation() throws LogOperationException{
        StringMessage firstMessage = mock(StringMessage.class);
        StringMessage secondMessage = mock(StringMessage.class);
        StringMessage thirdMessage = mock(StringMessage.class);

        when(firstMessage.isSameTypeOf(secondMessage)).thenReturn(true);
        when(secondMessage.isSameTypeOf(thirdMessage)).thenReturn(true);
        when(thirdMessage.getDecoratedMessage()).thenReturn("test message(x3)");

        testController.log(firstMessage);
        testController.log(secondMessage);
        testController.log(thirdMessage);
        testController.flush();

    }

    @Test
    public void shouldLogDecoratedInteger() throws LogOperationException{
        IntMessage message = mock(IntMessage.class);
        IntegerDecorator decorator = mock(IntegerDecorator.class);
        when(decorator.getDecoratedMessage(any(Message.class))).thenReturn("integer: 2");
        when(message.getDecorator()).thenReturn(decorator);

        String result = decorator.getDecoratedMessage(message);
        when(message.getDecoratedMessage()).thenReturn(result);

        testController.log(message);
        testController.flush();
        assertSysoutContains("integer: 2");

    }
}