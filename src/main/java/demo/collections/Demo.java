package demo.collections;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        Iterator<String> iterator = null; //GoF
        String current = null;
        for (   iterator = collection.iterator();
                iterator.hasNext();
                current = iterator.next()) {
            //loop body
        }

        for (String curr : collection) {

        }

        List<String> list = new LinkedList<String>();
        list.add(""); //tail
        list.add(0, "");
        list.get(1);

        Set<Cat> set = new TreeSet<>((o1, o2) -> 0);
        set.add(new Cat(""));


        Set<Cat> cats = new HashSet<>();

        Cat murik = new Cat("Murik");
        cats.add(murik);
        murik.setName("Murik-2");

        cats.add(new Cat("Murik-2"));

        cats.forEach(System.out::println);

        Collections.unmodifiableSet(cats);
    }
}

class Cat implements Comparable {
    private String name;

    Cat(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
