package test;

import com.acme.edu.message.IntMessage;
import com.acme.edu.message.LoggerMessage;
import com.acme.edu.message.StringMessage;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLOutput;


public class StringLoggerTest {
    private LoggerMessage message;
    private LoggerMessage currentMessage;

    @Before
    public void SetUp(){
        message = new StringMessage("test");
    }


    @Test
    public void ShouldBeTrueIfSameTypes(){
        StringMessage currentString = new StringMessage("test");
        IntMessage currentInt = new IntMessage(6);

        Assert.assertTrue(currentString.isSameType(message));
        Assert.assertFalse(currentInt.isSameType(message));
    }

}
