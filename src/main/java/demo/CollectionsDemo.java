package demo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

        for (String  current: collection) {

        }

        List<String> list = new ArrayList<>(50);
        list.add(""); //O(1)
        list.get(0);
        list.remove(0);
        list.add(""); //O(1)
        list.add(""); //O(1)
        list.add(""); //O(1)
        list.add(""); //O(n1)
        list.add(""); //...
        list.add(""); //O(n2)
        //O(???): add, remove, get(i), get(next)

//        Collections.sort();

        Set<Cat> cats = new HashSet<>();
        final Cat murzik = new Cat(1, "murzik");
        boolean added = cats.add(murzik);
        final Cat murik = new Cat(2, "murik");
        cats.add(murik);
        cats.add(new Cat(2, "ugolek"));
        murzik.setName("ugolek");
        murzik.setId(2);
        cats.add(new Cat(1, "murzik"));

        murik.setId(10);
        cats.add(new Cat(10, "murik"));

        System.out.println(cats);

        TreeSet set = new TreeSet<>(new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return 0;
            }
        });

        TreeSet set2 = new TreeSet<>((Comparator<Cat>) (o1, o2) -> 0); //1.
        set.add(new Cat(1, "barsik"));

        /**
        Queue q;
        q.poll();
        q.remove();
        q.offer();
        q.add();

        Map map;
        map.keySet()
        map.entrySet();
        map.values()
        */

        Collections.sort(list); //Comparable || Compaprator
        Collections.emptyList();
        Collections.synchronizedCollection(list);
        Collections.unmodifiableSet(set);

        final Map<Cat, Cat> catFriends = new TreeMap<>((o1, o2) -> 0);
        catFriends.put(new Cat(1, "murik"), new Cat(1, "murik"));
        catFriends.entrySet();

    }
}

class Cat implements Comparable<Cat> {
    private int id;
    private String name;

    public Cat(int id, String name) {
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

    //@Override
    @NotNull
    public String toString(@Nullable String param) {
        return param;
        /*"{" +
            "'id'='" + id +
            "', 'name'='" + name + '\'' +
        '}';*/
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (getId() != cat.getId()) return false;
        return getName() != null ? getName().equals(cat.getName()) : cat.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(@NotNull Cat o) {
        return 0;
    }
}