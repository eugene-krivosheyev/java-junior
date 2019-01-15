package demo.collectionsdemo;

import java.util.HashSet;
import java.util.Set;

public class CollectionsDemo {
    public static void main(String[] args) {
        Set<Cat> cats = new HashSet<>();
        Cat cat1 = new Cat("Cat1");
        cats.add(cat1);
        cat1.setName("Cat2");
        cats.add(new Cat("Cat2"));

        for (Cat e : cats) {
            cats.add(new Cat("1"));
        }
        cats.forEach(System.out::println);
    }
}

class Cat {
    private String name;

    Cat(String name) {
        this.name = name;
    }

    //!!!
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
        return "Cat {" +
                "name='" + name + '\'' +
                '}';
    }
}
