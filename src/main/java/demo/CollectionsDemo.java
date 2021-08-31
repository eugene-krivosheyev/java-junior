package demo;

import javax.naming.OperationNotSupportedException;
import java.util.*;

import static java.util.Comparator.comparingInt;

public class CollectionsDemo {
    public static void main(String[] args) {
        /* Performance issue!!!
        Collection<String> collection = new ArrayList<>();
        for (int counter = 0; counter < 1_000_000; counter++) {
            collection.add("");
        }
         */

        Set<Person> persons = new HashSet<>();
        Person vasya = new Person(1, "vasya");
        persons.add(vasya);
        System.out.println(persons.add(new Person(1, "vasya")));
        persons.forEach(System.out::println);

        System.out.println("------");
        vasya.setId(2);
        vasya.setName("petya"); // -> hashCode

        Person petya= new Person(2, "petya");
        persons.add(petya);

        persons.forEach(System.out::println);

        Collection<Person> objects = new TreeSet<>(comparingInt(Person::getId));
        objects.add(new Person(2, "petya"));

        Map<String, Person> hashtable = new HashMap<>();
        hashtable.put(null, vasya);
        System.out.println(hashtable.get(null));
        hashtable.entrySet().forEach(e -> System.out.println(e));

        Arrays.asList();
//        Arrays.binarySearch();

        Set.of(1,2,3);
        List.of(1,2,3);

//        Collections.sort();
//        List uli = Collections.unmodifiableSet(set);
//        uli.add() -> OperationNotSupportedException
    }
}

@SuppressWarnings({ "unchecked", "rawtypes" })
class Person implements Comparable<Person> {
    private List friends = new ArrayList();
    private int id;
    private String name;

    public Person(int id, String name) {
        friends.add(0);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getId() == person.getId() && getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "Person {" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.id - o.id;
    }
}