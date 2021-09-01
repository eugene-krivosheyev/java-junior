package com.acme.edu.unit;

import com.acme.edu.FileCaptureAndAssertionAbility;
import com.acme.edu.Logger;
import com.acme.edu.Prefix;
import com.acme.edu.message.EmptyMessage;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.FileSaver;
import com.acme.edu.saver.SaveException;
import com.acme.edu.saver.Saver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileSaverTest implements FileCaptureAndAssertionAbility{
    private String FILE_NAME = "demo.txt";
    private Saver saver;

    //region given
    @BeforeEach
    void setup() {
        saver = new FileSaver(FILE_NAME, "windows-1251", 512);
    }

    @AfterEach
    void reset(){
        resetFile(FILE_NAME);
    }

    @Test
    public void shouldThrowExceptionWhenTryingToLogNullMessage() {
        EmptyMessage emptyMessage = new EmptyMessage();

        assertThrows(SaveException.class, () -> saver.save(emptyMessage.getDecoratedMessage()));
    }

    @Test
    public void loggerShouldWriteStringToFile() throws SaveException {
        Logger.log(1);
        Logger.flush();
        Logger.log(0);
        Logger.flush();
        Logger.log(-1);
        Logger.flush();
        //endregion

        //region then
        assertFileContains(Prefix.PRIMITIVE.value + " 1", FILE_NAME);
        assertFileContains(Prefix.PRIMITIVE.value + " 0", FILE_NAME);
        assertFileContains(Prefix.PRIMITIVE.value + " -1", FILE_NAME);
    }
}
