package demo;

import java.io.IOException;

import static java.lang.Runtime.*;

public class SyslibDemo {
    public static void main(String... args) {
        getRuntime().addShutdownHook(new Thread(() -> System.out.println("stopping.....")));
        getRuntime().availableProcessors();
//        getRuntime().exec("echo 'fff' ").waitFor()
        System.gc();

        System.getProperties().forEach((k,v) -> System.out.println(k + " : " + v));

        System.out.println();
        for (String arg : args) {
            System.out.println(arg);
        }

        System.out.println(">> " + System.getProperty("prop"));

        Math.random();


    }
}
