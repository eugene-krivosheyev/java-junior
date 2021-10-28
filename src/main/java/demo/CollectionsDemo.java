package demo;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        final Collection<Object> objects = new ArrayList<>(10_000);
        for (int counter = 0; counter < 10_000; counter++) {
            objects.add(counter);
        }

        for (Object current : objects) {
            System.out.println(current);
        }
        //1M

        final Set<Cat> cats = new HashSet<>();
        final Cat cat1 = new Cat("1");
        final Cat cat2 = new Cat("2");

        cats.add(cat1);
        cat1.setName("2");
        cats.add(cat2);

        System.out.println(cats);
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
    public String toString() {
        return "Cat {" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(getName(), cat.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}