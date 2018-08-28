package com.acme.edu.logger;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.controller.Controller;
import com.acme.edu.message.IntMessage;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Java_1 on 28.08.2018.
 */
public class ControllerTest implements SysoutCaptureAndAssertionAbility {
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @Test
    public void shouldDoNothingWhenMessageIsNull() {
        Controller testController = new Controller();
        testController.setCurrentMessage(null);
        testController.log(null);
        assertSysoutContains("");
    }

    @Test
    public void shouldLogIntegers() {
        Controller testController = new Controller();
        testController.log(new IntMessage(2));
        testController.flush();
        assertSysoutContains("2");

    }
}