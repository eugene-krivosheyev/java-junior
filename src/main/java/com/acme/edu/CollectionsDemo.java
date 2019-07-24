package com.acme.edu;

import java.util.*;

public class CollectionsDemo {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>(10_000);
        for (int i = 0; i < 10_000; i++) {
            elements.add(i);
        }



        Set dogeeees = new HashSet();
        Dog tuzik = new Dog(1, "Tuzik");
        dogeeees.add(tuzik);
        tuzik.setName("Sharik");
        Dog sharik = new Dog(1, "Sharik");
        dogeeees.add(sharik);

        dogeeees.forEach(System.out::println);
        System.out.println(sharik.equals(tuzik));



        Iterator iterator = elements.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            iterator.next();
            if (++i == 3) iterator.remove();
        }



        Collections.sort(elements, (o1, o2) -> o2 - o1);
        Collections.unmodifiableList(elements).add(null);
    }
}

class Dog {
    private int id;
    private String name;

    public Dog(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        if (id != dog.id) return false;
        return name != null ? name.equals(dog.name) : dog.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

