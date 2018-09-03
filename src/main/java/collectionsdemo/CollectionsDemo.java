package collectionsdemo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class CollectionsDemo {
    public static void main(String[] args) {
        Collection<Integer> list = Arrays.asList(1,6,2,5,3,4);
        list.stream()
            .filter(e -> e >= 3)
            .map(CollectionsDemo::dec)
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .limit(2)
            .forEach(System.out::println);
//            .collect(Collectors.toList())
//            .reduce((e1, e2) -> e1 + e2); //fold
    }

    private static int dec(int param) {
        return param - 1;
    }
}
