package collectionsdemo;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        Iterator<Integer> iter =  Arrays.asList(1,2,3).iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
//            iter.remove();
        }


        Set<Cat> set = new HashSet<>();
        set.add(new Cat("murik"));
        set.add(new Cat("super"));
        for (Cat cat : set) {
            cat.setName("rrrr");
        }
//
//        set.add(murik);
//        murik.setName("super");
//
//        set.add(sup);

        System.out.println(set);

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
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat)) return false;

        Cat cat = (Cat) o;

        return getName() != null ? getName().equals(cat.getName()) : cat.getName() == null;

    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}
