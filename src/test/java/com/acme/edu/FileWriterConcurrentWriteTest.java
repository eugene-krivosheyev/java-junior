package com.acme.edu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class FileWriterConcurrentWriteTest {
    private ExecutorService pool;

    @Before
    public void setUp() throws IOException {
        pool = Executors.newFixedThreadPool(100);
    }

    @Test
    public void shouldConsistentWriteWhenConcurrentWrites() throws InterruptedException {
        IntStream.range(1, 100).forEach(n -> {
            pool.submit(() -> {
                try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("experiment.txt", true))) {
                    IntStream.range(1, 1_000).forEach(l -> {
                        try {
                            bufferedWriter.write(n + " " + l + "test string test string test string");
                            bufferedWriter.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
    }
}
