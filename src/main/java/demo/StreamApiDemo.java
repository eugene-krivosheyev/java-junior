package demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiDemo {
    public static void main(String[] args) {
//        IntStream.range(0, 11)
        List.of(9,8,7,6,5,4,3,2,1)
            .parallelStream()
                .filter( e -> e < 6 )
                .map(Object::toString)
                .sorted()
//                .reduce( (e1,e2) -> e1 + e2 );
//                .collect(Collectors.toSet())
                .forEach(e -> {throw new RuntimeException();});
    }
}
