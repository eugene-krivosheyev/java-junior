package com.acme.edu.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrencyDemo {
    public static void main(String[] args) throws InterruptedException {
        final Account account1 = new Account(100_000);
        final Account account2 = new Account(0);
        final Transaction tx = new Transaction();
        final ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100_000; i++) {
            pool.submit(() -> tx.transaction(account1, account2, 1));
        }

        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println(account1.getAmount());
        System.out.println(account2.getAmount());

    }
}

class Counter {
    private int counter;
    private Object monitor = new Object();

    /**
     * Data Race
     */
    public void increment() {
        //...
        synchronized (this.monitor) {
            // <-
            // update
            // ->
            this.counter++;
        }
        //...
    }

    public int getCounter() {
        synchronized (this.monitor) {
            return counter;
        }
    }
}

class Transaction {
    /**
     * Ok for consistency, but performance fail
     */
    public synchronized void transaction(Account a1, Account a2, int amount) {
        a1.withdraw(amount);
        a2.credit(amount);
    }
}

class Account {
    private int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void withdraw(int amount) {
        this.amount -= amount;
    }

    public void credit(int amount) {
        this.amount += amount;
    }
}