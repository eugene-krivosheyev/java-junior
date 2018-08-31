package collectionsdemo;

import syslib.Cat;

import java.util.*;

import static java.util.Comparator.comparing;

public class CollectionsDemo {
    public static void main(String[] args) {
        Set<Cat> cats = new TreeSet<>(comparing(Cat::getName));


    }
}
