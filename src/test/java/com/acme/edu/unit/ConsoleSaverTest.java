package com.acme.edu.unit;

import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.Saver;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.fest.assertions.Assertions.assertThat;

public class ConsoleSaverTest{

   @Test
     public void ShouldMessageBeTypedInConsoleWhenConsoleSaverSaves() throws IOException {
       Saver sut = new ConsoleSaver();
       ByteArrayOutputStream OUT = new ByteArrayOutputStream();
       OUT.reset();
       System.setOut(new PrintStream(OUT));

       sut.save("test message");

       assertThat(OUT.toString()).isEqualTo("test message");
   }

}
