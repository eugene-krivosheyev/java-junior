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

    private Saver saver;

    //region given
    @BeforeEach
    void setup() {
        saver = new FileSaver("demo.txt", "windows-1251");
    }

    @Test
    public void shouldThrowExceptionWhenTryingToLogNullMessage() {
        EmptyMessage emptyMessage = new EmptyMessage();

        assertThrows(SaveException.class, () -> saver.save(emptyMessage.getDecoratedMessage()));
    }

    @Test
    public void shouldWriteStringToFile() throws SaveException {
        Logger.log(1);
        Logger.flush();
        Logger.log(0);
        Logger.flush();
        Logger.log(-1);
        Logger.flush();
        //endregion

        //region then
        assertFileContains(Prefix.PRIMITIVE.value + " 1");
        assertFileContains(Prefix.PRIMITIVE.value + " 0");
        assertFileContains(Prefix.PRIMITIVE.value + " -1");
    }
}
