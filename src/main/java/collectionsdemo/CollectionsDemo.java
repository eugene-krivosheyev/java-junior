package collectionsdemo;

import syslib.Cat;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        Set<Cat> cats = new HashSet<>();

        Cat murik = new Cat("Murka");
        cats.add(murik);
        murik.setName("Murik");

        Cat murikNew = new Cat("Murik");
        cats.add(murikNew);
        cats.remove(murikNew);

        cats.forEach(System.out::println);

        System.out.println(
            cats.contains(new Cat("Murka"))
        );
    }
}
