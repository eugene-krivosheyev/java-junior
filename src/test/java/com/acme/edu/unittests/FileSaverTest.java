package com.acme.edu.unittests;

import com.acme.edu.exception.SaverException;
import com.acme.edu.message.IntMessage;
import com.acme.edu.message.StringMessage;
import com.acme.edu.saver.FileSaver;
import com.acme.edu.saver.Saver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.*;

public class FileSaverTest {

    @Before
    public void clean(){
        File file = new File("log.txt");
        file.delete();
    }

    @Test
    public void shouldSaveToFile() throws SaverException {
        Saver mySaver = new FileSaver("log.txt");
        StringMessage stringMessage= new StringMessage("ololo");
        mySaver.save(stringMessage);
        assertThat(linesOf(new File("log.txt"))).containsExactly(
                "string: ololo"
        );

    }

    @Test
    public void shouldSaveManyToFile() throws SaverException {
        Saver mySaver = new FileSaver("log.txt");
        StringMessage stringMessage= new StringMessage("ololo");
        mySaver.save(stringMessage);
        IntMessage intMessage = new IntMessage(2);
        mySaver.save(intMessage);
        IntMessage intMessage2 = new IntMessage(3);
        mySaver.save(intMessage2);
        assertThat(linesOf(new File("log.txt"))).containsExactly(
                "string: ololo",
                "primitive: 2",
                "primitive: 3"
        );
    }
}
