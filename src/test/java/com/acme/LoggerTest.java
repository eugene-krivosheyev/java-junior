package com.acme;

import com.acme.logger.LoggerController;
import com.acme.logger.LoggerSaver;
import com.acme.logger.LoggingException;
import com.acme.logger.SavingException;
import org.junit.Test;

public class LoggerTest {
    @Test(expected = LoggingException.class)
    public void shouldGetExceptionWhenLogOperationAndSavingException() throws LoggingException {
        LoggerController loggerToTest = new LoggerController(message -> {
            throw new SavingException("test exception");
        });

        loggerToTest.log("test message");
    }
}
