package demo.collectionsdemo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CollectionsDemo {
    public static void main(String[] args) {
        Collection<String> collection = new HashSet<>(); //LoadFactor ==
        collection.add("1");
        collection.add("2");
        collection.add("3"); //hashCode == 1004576
        collection.add("3"); // -> return false

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
