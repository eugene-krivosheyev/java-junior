package com.acme.edu.collections;

import org.jetbrains.annotations.NotNull;

import java.util.*;

import static java.util.Collections.sort;
import static java.util.Comparator.comparing;

public class CollectionsDemo {
    public static void main(String[] args) {
        Collection set = new HashSet();

        Cat murzik = new Cat("Murzik");
        set.add(murzik);
        Cat chineeseMurzik = new Cat("Murzik2");
        set.add(chineeseMurzik);
        chineeseMurzik.setName("Murzik");

        set.forEach(System.out::println);


        Collection<Cat> treeSet = new TreeSet<>(comparing(Cat::getName));
        treeSet.add(new Cat("qqq"));


    }
}

class Cat {
    private String name;

    public Cat(String name) {
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
        return "name='" + name + "'";
    }
}