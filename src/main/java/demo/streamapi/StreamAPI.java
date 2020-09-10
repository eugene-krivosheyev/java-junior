package demo.streamapi;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.reverseOrder;

public class StreamAPI {
    public static void main(final String[] args) {
        final List<Integer> stream = Arrays.asList(2, 8, 3, 7, 4, 6, 5);
//        final Optional<Integer> reduce =
                stream.parallelStream()
                .map(e -> e + 1)
                .filter(e -> e % 2 == 0)
                .sorted(reverseOrder())
                .forEach(e ->  args[0] = "" );
//                .reduce(Integer::sum);
//            .forEach(System.out::println);

        m(p -> 2*p).apply(1);
    }

//    public f() accumulate(x, todo) {
//        return todo(f(g(c(x))));
//    }

    public static Function<Integer, Integer> m(Function<Integer, Integer> todo) {
        //.....
        //.....
        final Integer applyResult = todo.apply(2);
        System.out.println(applyResult);
        return x -> x + applyResult;
    }
}
