package com.acme.edu.testunit;

import com.acme.edu.LoggerController;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.filters.Filter;
import com.acme.edu.filters.LengthFilter;
import com.acme.edu.messages.Message;
import com.acme.edu.messages.StringMessage;
import com.acme.edu.savers.Saver;
import kotlin.ExtensionFunctionType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



public class LengthFilterTest implements SysoutCaptureAndAssertionAbility {
    LoggerController controllerSut;

    @BeforeEach
    public void setBasicArguments() {
        resetOut();
        captureSysout();
        LengthFilter filterDummy = new LengthFilter(10);
        Saver saveDummy = mock(Saver.class);
        controllerSut = new LoggerController(saveDummy, filterDummy);
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }

    @Test
    public void lengthFilterShouldDismissShortMessages(){
        String forbiddenString = "LONGMESSAGE";
        Message longMessage = mock(Message.class);
        when(longMessage.getValue()).thenReturn(forbiddenString);
        controllerSut.log(new StringMessage(forbiddenString));

        assertSysoutNotContains(forbiddenString);
    }


}
