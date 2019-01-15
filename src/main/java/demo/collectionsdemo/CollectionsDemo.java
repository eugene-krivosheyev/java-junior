package demo.collectionsdemo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CollectionsDemo {
    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("2", "1", "3");

        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(
                iterator.next() //2 functions
            );
        }

        for (String e : collection) {
            System.out.println(e);
        }

        collection.stream()
                .map(Integer::parseInt)
                .forEach(System.out::println);
    }
}
