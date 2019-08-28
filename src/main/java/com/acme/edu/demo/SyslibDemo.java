package com.acme.edu.demo;

import java.io.IOException;
import java.util.Date; //nope!
import java.time.Instant; //joda time - yep!
import java.util.Properties;

public class SyslibDemo {
    public static void main(String[] args) throws IOException {
        System.currentTimeMillis(); //epoch
        System.nanoTime();

        System.gc();

        //Properties = Map<String, String>
        final Properties properties = System.getProperties();
        properties.list(System.out);
        properties.getProperty("file.encoding");
        // java -Dfile.encoding=cp866 -Dk=v -cp my.jar MyClass "prog args"

//        System.arraycopy();
        System.load(""); //loadLibrary() //JNI -> JNA -> ???

        final Runtime runtime = Runtime.getRuntime();
        runtime.exec("rm -rf /");
        runtime.availableProcessors();
        runtime.addShutdownHook(new Thread(() -> System.out.println("bye!")));

        
    }
}
