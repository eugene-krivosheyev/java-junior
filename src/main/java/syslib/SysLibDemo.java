package syslib;

import java.io.IOException;
import java.lang.*;
import java.util.function.BiConsumer;

import static java.lang.System.getProperty;

/**
 * JNI | JNA | ???
 */
public class SysLibDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.getProperties().forEach(
                (k, v) -> System.out.println(k + " : " + v)
        );
        System.out.println(getProperty("file.encoding"));
        Runtime.getRuntime();

        System.out.println(
            ((Cat)(new Cat("m", 10).clone())).getName()
        );

        Integer i1 = 5; //new Integer() + intern with diapason
        int i2 = i1; //i1.intValue();
        while (i1 < 10_000_000) {
            i1++;
        }

        Integer int1 = 127, int2 = 127;
        System.out.println(int1 == int2);
    }
}