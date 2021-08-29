package org.example;

import com.acme.edu.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );

        Logger logger = new Logger();
        logger.log("one");
        logger.log("one");
        logger.log("two");
        logger.log(1);
        logger.log(2);
        logger.log(3);
        logger.log("end");
        logger.flush();
    }
}
