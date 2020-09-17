package demo;



import java.util.Arrays;
import java.util.List;


public class StreamApiDemo {
    public static void main(String[] args) {
        //Arrays.asList(1,2,3,4,5)
        //range(0, 5)
        System.out.println(
                Arrays.asList(1, 2, 3, 4, 5).stream()
                .map(Dog::new)
                .filter(dog -> dog.getId() > 2)
                .sorted((d1,d2) -> d2.getId() - d1.getId())
//                    .collect(Collectors.toList())
//                    .forEach(System.out::println)
//                    .reduce()
//                    .max() // .min()
                    .findAny() //findAny()
//                        .get()
//                        .orElse(new Dog(0))
                        .orElseThrow(RuntimeException::new)
        );
    }
}

class Dog {
    private int id;

    public Dog(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}