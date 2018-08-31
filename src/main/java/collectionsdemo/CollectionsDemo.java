package collectionsdemo;

import syslib.Cat;

import java.util.*;

import static java.util.Comparator.comparing;

public class CollectionsDemo {
    public static void main(String[] args) {
        Map<String, Cat> cats = new HashMap<>();
        cats.get("");
        cats.keySet();
        cats.values();
        cats.entrySet();

//        Collections.sort();
//        Collections.synchronizedXXX()
//        Collections.unmodifiableXXX()
//        Collections.binarySearch()
//        ArrayList<Cat> cats2 = Collections.checkedCollection(new ArrayList(), Cat.class);
    }
}
