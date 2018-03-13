package com.acme.edu.collectionsdemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.joining;

public class CollectionsDemo {
    public static void main(String[] args) {
        /*
        Collection<String> elements = Arrays.asList("1", "2", "3");

        for (Iterator<String> iter = elements.iterator(); iter.hasNext(); ) {
        }

        for (String element : elements) {
        }

        elements.forEach(System.out::println);

//        Collections.sort(elements);
*/
        Set set = new HashSet();
        Cat murik = new Cat("Murik");
        set.add(murik);
        murik.setName("Murik II");

        Cat murik2 = new Cat("Murik II");
        set.add(murik2);

        System.out.println(murik.equals(murik2));
        set.forEach(System.out::println);


        Set<String> largeSet = new HashSet<>(10_000);
        largeSet.add("str1");
        largeSet.add("str2");
        largeSet.add("str3");
        largeSet.add("str4");
        largeSet.add("str5");
        largeSet.add("str6");
        largeSet.add("str7");
        largeSet.add("str8");
        largeSet.add("str9");

        Set<String> treeSet = new TreeSet<>((o1, o2) -> -o1.compareTo(o2));
        treeSet.add("1");

        Map<String, Boolean> cats = new HashMap<>();
        cats.put(null, new Boolean(true));
        System.out.println(cats.get(null));

        Map<Object, Object> objectObjectHashMap = new HashMap<>();
        Collection<Object> objects = new HashSet<>();

        //Fail-fast iterators VS Fail-safe iterators
//        objects.iterator().remove();
        //Concurrent VS Thread-safe collections (old-school) VS Regular
//        java.util.concurrent.ConcurrentMap;

        /*
        Collections.sort(new ArrayList<String>());
        Collections.synchronizedCollection(treeSet);
        Map<String, Boolean> unmCats = Collections.unmodifiableMap(cats);
        unmCats.put("111", null);
        */


//        new ArrayList<>().parallelStream().map();

        Stream<String> stream = Stream.<String>of("1", "2", "3", "4", "5", "6")
                .map(Integer::parseInt)
                .filter(e -> e < 4)
                .sorted(reverseOrder())
                .map(e -> Integer.toString(e));

        String collected = stream.collect(joining(", "));
        System.out.println(collected);

//        new ArrayList<>().forEach();
    }
}

class Cat {
    private String name;

    Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        return name != null ? name.equals(cat.name) : cat.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
