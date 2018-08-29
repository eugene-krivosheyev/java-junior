package com.acme.edu.logger;

import com.acme.edu.Decorator.IntegerDecorator;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.controller.Controller;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.Message;
import com.acme.edu.message.StringMessage;
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
    public void shouldDoNothingWhenMessageIsNull() {
        testController.setCurrentMessage(null);
        testController.log(null);
        assertSysoutContains("");
    }

    @Test
    public void shouldLogInteger() {
        IntMessage message = mock(IntMessage.class);
        message.setValue(2);
        when(message.getDecoratedMessage()).thenReturn("primitive: 2");
        testController.log(message);
        testController.flush();
        assertSysoutContains("2");

    }

    @Test
    public void shouldLogSequentIntegersAsSum() {
        IntMessage firstMessage = mock(IntMessage.class);
        IntMessage secondMessage = mock(IntMessage.class);
        IntMessage resultMessage = mock(IntMessage.class);
        firstMessage.setValue(5);
        secondMessage.setValue(3);
        resultMessage.setValue(8);
        when(firstMessage.accumulate(secondMessage)).thenReturn(resultMessage);
        when(resultMessage.getDecoratedMessage()).thenReturn("primitive: 8");
        testController.log(firstMessage);
        testController.log(secondMessage);
        testController.flush();

    }

    @Test
    public void shouldLogSequentStringsWithAccumulation() {
        StringMessage firstMessage = mock(StringMessage.class);
        StringMessage secondMessage = mock(StringMessage.class);
        StringMessage thirdMessage = mock(StringMessage.class);
        firstMessage.setValue("test message");
        secondMessage.setValue("test message");
        thirdMessage.setValue("test message");
        when(firstMessage.accumulate(secondMessage)).thenReturn(secondMessage);
        when(secondMessage.accumulate(thirdMessage)).thenReturn(thirdMessage);
        when(thirdMessage.getDecoratedMessage()).thenReturn("test message(x3)");
        testController.log(firstMessage);
        testController.log(secondMessage);
        testController.log(thirdMessage);
        testController.flush();

    }

    @Test
    @Ignore
    public void shouldLogDecoratedInteger() {
        IntMessage message = mock(IntMessage.class);
        IntegerDecorator decorator = mock(IntegerDecorator.class);
        message.setValue(2);
        message.setDecorator(decorator);
        when(decorator.getDecoratedMessage(any(Message.class))).thenReturn("integer: 2");
  //      when(message.getDecoratedMessage()).thenReturn("integer: 2");
        testController.log(message);
        testController.flush();
        assertSysoutContains("2");

    }
}