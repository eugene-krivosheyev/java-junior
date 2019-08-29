package com.acme.edu.mylogger;

import java.util.Collection;
import java.util.Optional;

public class SuperCurrentAccumulator implements SuperAccumulator {
    private static int sum;

    @Override
    public Optional<Command> accumulate(Collection<Command> collection) {
        //Stream.of(collection).parallel().reduce((e1, e2) -> e1.);
        //collection.stream().reduce((e1, e2) -> (int)e1.getMessage() + (int)e2.getMessage());
        //int sum = collection.stream().mapToInt().sum();
        makeZero();
        /*
        for (Command element : collection) {
            int newSum = sum + (int)element.getMessage();
            if (newSum < 0) {
                throw new ArithmeticException("Overflow");
            }
            sum+=(int)element.getMessage();
        }
         */
        //return sum;
        /*
        try {
            return collection.stream().mapToInt(e -> (int) e.getMessage()).sum();
        } catch (ClassCastException exs) {
            return collection.stream().mapToInt(e -> (byte) e.getMessage()).sum();
        }
         */
        return collection.stream().reduce(Command::accumulate);
        //return collection.stream().mapToInt(e -> (int) e.getMessage()).sum();
    }

    @Override
    public int getPrevSum() {
        return sum;
    }

    public void makeZero() {
        sum = 0;
    }
}
