package com.acme.edu.demo;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        Collection collection = new HashSet(10_000);
        Map<String, String> map = new HashMap<>();
        map.put(null, "OPPA!!!");

        map.forEach((k,v) -> System.out.println(k + ":" + v));

//        Collections.sort();

        final Collection<Squirrel> squirrels = new HashSet<>();
        final Squirrel tool = new Squirrel("tool");
        squirrels.add(tool);
        squirrels.forEach(System.out::println);
        tool.setName("opeth");
        Squirrel gojira = new Squirrel("opeth");
        squirrels.add(gojira);

        System.out.println(">>>>");
        squirrels.forEach(System.out::println);

    }
}

class Squirrel {
    private String name;

    public Squirrel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Squirrel {" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Squirrel squirrel = (Squirrel) o;

        return name != null ? name.equals(squirrel.name) : squirrel.name == null;
    }

    @Override
    public int hashCode() {
        return this.name != null ? this.name.hashCode() : 0;
    }
}
