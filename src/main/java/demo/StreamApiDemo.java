package demo;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class StreamApiDemo {
    public static void main(String[] args) {
//        Stream.of
//        IntStream.range(2,10)
        List.of(1, 9, 2, 8, 3, 7, 4, 6, 5)
                .stream()
                .filter(e -> e < 6)
                .sorted((e1, e2) -> e2 - e1)
                .map(e -> Integer.toString(e))
//                .reduce("", (s1,s2) -> s1 + s2);
//                .collect(joining(","));
//                .collect(Collectors.toSet());
                .limit(3)
                .skip(1)
                .forEach(System.out::println);

        List.of(1,2,3,3,3,3,3,3,3,3,3,3,3,3).parallelStream();
    }

    private static Integer getFromDb() throws Exception {
        Optional<Integer> given = Optional.of(1);
        return given.orElseThrow(Exception::new);
    }
}
