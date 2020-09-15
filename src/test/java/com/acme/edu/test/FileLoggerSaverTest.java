package com.acme.edu.test;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.exceptions.FileLoggerSaverException;
import com.acme.edu.saver.ConsoleLoggerSaver;
import com.acme.edu.saver.FileLoggerSaver;
import org.junit.Before;
import org.junit.Test;

public class FileLoggerSaverTest  implements SysoutCaptureAndAssertionAbility {
    private FileLoggerSaver saver;

    @Before
    public void setUp() {
        saver = new FileLoggerSaver();
    }


    @Test(expected = FileLoggerSaverException.class)
    public void shouldThrowExceptionIfMessageIsNull() throws FileLoggerSaverException {
        saver.save(null);
    }


}
