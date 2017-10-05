package com.acme;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.util.Comparator.reverseOrder;

public class InnerClassDemo {
    public static void main(String[] args) {
        DelayedWorker queue = new DelayedWorker();

        // - >
        queue.doLater(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return parseInt(args[0]);
            }
        });
        queue.doLater(param -> parseInt(args[0]));


        queue.doLater(p -> {
            return 0;
        });
        queue.doLater(p -> Integer.bitCount(p));
        queue.doLater(Integer::bitCount);
        queue.doLater(InnerClassDemo::m);


        Arrays.asList(1,6,2,5,3,4,10,1,11,9,8,7).parallelStream()
            .filter(e -> e > 0)
            .map(Object::toString)
            .sorted(reverseOrder())
            .forEach(System.out::println);
    }

    private static int m(int arg) {
        return arg + 1;
    }
}

class DelayedWorker {
    private int state;

    public int doLater(Function<Integer, Integer> toDo) {
        //....
        return toDo.apply(0);
        //....
    }
}

@FunctionalInterface
interface Worker {
    int doWork(int param);
}
