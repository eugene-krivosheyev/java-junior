package com.acme.edu.lambdademo;

import com.acme.edu.expressionproblem.message.IntMessage;
import com.acme.edu.expressionproblem.message.Message;
import com.acme.edu.expressionproblem.message.StringMessage;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class LambdaDemo {
    public static void main(String[] args) {

        int var = 5; //final
        Message m = new IntMessage(0);

        Framework framework = new Framework();
        framework.execute(
            (param1, param2) -> { //Closure
                System.out.println(param1);
//                var = 0;
                System.out.println(var);

                System.out.println(m);
                m.setValue(1);
            }
        );

        List<Message> messages = Arrays.asList(
                new IntMessage(111111),
                new StringMessage("223"),
                new IntMessage(33),
                new StringMessage("4444")
        );

        List<String> list = messages.parallelStream()
                .map(Message::toString)
                .sorted(comparingInt(String::length))
                .filter(e -> e.length() > 2)
                .collect(toList());

        list.forEach(System.out::println);

        java.util.function.Supplier<Integer> my = () -> {
            System.out.println();
            return 4;
        };

    }
}

class Framework {
    public void execute(Executable toDo) {

    }
}

@FunctionalInterface
interface Executable {
    void toDo(Integer param1, Integer param2);
}