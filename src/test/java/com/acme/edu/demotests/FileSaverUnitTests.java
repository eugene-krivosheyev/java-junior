package com.acme.edu.demotests;

import com.acme.edu.command.Command;
import com.acme.edu.exceptions.SaveException;
import com.acme.edu.save.FileSaverStateful;
import com.acme.edu.save.FileSaverStateless;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class FileSaverUnitTests {

    @Test(expected = SaveException.class)
    public void shouldFileSaverStatelessThrowCustomExceptionWhenWrongFileNameCame() throws IOException, SaveException {
        FileSaverStateless fileSaverStateless = new FileSaverStateless("");
        fileSaverStateless.save(mock(Command.class));
    }

    @Test
    public void shouldFileSaverStatelessSaveToFile() throws IOException, SaveException {
        FileSaverStateless fileSaverStateless = new FileSaverStateless("test.txt", false);
        Command stub = mock(Command.class);

        fileSaverStateless.save(stub);
        //assertThat(fileSaverStateless).isNotNull();
    }

    @Test(expected = IOException.class)
    @Ignore
    public void shouldFileSaverStatefulThrowExceptionWhenWrongFileNameCame() throws IOException{
        FileSaverStateful fileSaverStateful = new FileSaverStateful("");
        fileSaverStateful.save(mock(Command.class));
    }

    @Test
    @Ignore
    public void shouldFileSaverStatefulSaveToFile() throws IOException {
        FileSaverStateful fileSaverStateful = new FileSaverStateful("test.txt", false);
        Command stub = mock(Command.class);

        fileSaverStateful.save(stub);
        //assertThat(fileSaverStateful).isNotNull();
    }
}
