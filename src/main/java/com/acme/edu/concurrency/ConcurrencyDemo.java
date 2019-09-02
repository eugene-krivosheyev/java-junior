package com.acme.edu.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrencyDemo {
    public static void main(String[] args) throws InterruptedException {
        final Account account1 = new Account(100_000);
        final Account account2 = new Account(0);
        final Transaction tx = new Transaction();

        final ExecutorService pool = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 100_000; i++) {
            pool.submit(() -> tx.noLockingTransaction(account1, account2, 1));
        }
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println(account1.getAmount() + " + " + account2.getAmount() + " == ");
        System.out.println(account1.getAmount() + account2.getAmount());

    }
}

class Counter {
    private int counter;
    private final Object monitor = new Object();

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
    public void syncWithFileLevelLockingTransaction(Account a1, Account a2, int amount) {
        synchronized (a1) {
            synchronized (a2) {
                int amount1 = a1.getAmount();
                a1.setAmount(amount1 - amount);
                int amount2 = a2.getAmount();
                a2.setAmount(amount2 + amount);
            }
        }
    }

    public synchronized void syncWithCoarseLevelLockingTransaction(Account a1, Account a2, int amount) {
        int amount1 = a1.getAmount();
        a1.setAmount(amount1 - amount);
        int amount2 = a2.getAmount();
        a2.setAmount(amount2 + amount);
    }

    public void noLockingTransaction(Account a1, Account a2, int amount) {
        int amount1 = a1.getAmount();
        a1.setAmount(amount1 - amount);
        int amount2 = a2.getAmount();
        a2.setAmount(amount2 + amount);
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

    public void setAmount(int amount) {
        this.amount = amount;
    }
}