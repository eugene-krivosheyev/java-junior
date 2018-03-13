package com.acme.edu.collectionsdemo;

import java.util.*;

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
