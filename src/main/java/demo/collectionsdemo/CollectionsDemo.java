package demo.collectionsdemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> collection = new ArrayList<>(500);
        collection.add(0, "1"); //!Comparable
        collection.add("2");
        collection.add("3"); //hashCode == 1004576
        collection.add("3"); // -> return false
        collection.get(0);

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
