package com.acme.edu.concurrency;

public class MicroBenchmarkDONT {
    public static void main(String[] args) {
        final ServerController sut = new ServerController();
        /* DONT!
        for (i = 0..100) {
            int result = f();
            blackhle.consulme(result)
        }
        */

        // -> JMH
    }
}
