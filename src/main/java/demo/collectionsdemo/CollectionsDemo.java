package demo.collectionsdemo;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import static java.util.Comparator.reverseOrder;

public class CollectionsDemo {
    public static void main(String[] args) {
        Collection<String> collection = new TreeSet<>(reverseOrder());
        collection.add("1"); //!Comparable
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
