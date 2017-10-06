package com.acme.collectionsdemo;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        Collection<String> collection;

//        Collections.sort(new ArrayList());
//        Collections.synchronizedCollection(???);
//        Collections.unmodifiableMap();

        Set<Cat> cats = new HashSet<>();
        Cat murik = new Cat("Murik");
        cats.add(murik);
        murik.setName("Murzik");
        cats.add(new Cat("Murzik"));

        cats.forEach(System.out::println);
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

    @Override
    public String toString() {
        return "cat='" + name + '\'';
    }
}
