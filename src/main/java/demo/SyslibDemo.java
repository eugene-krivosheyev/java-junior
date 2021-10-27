package demo;

import java.io.File;
import java.util.Objects;
import java.util.function.BiConsumer;

public class SyslibDemo {
    public static void main(String[] args) {
//        System.exit(0);

        System.getProperties()
                .forEach( (k, v) -> System.out.println(k + ":" + v) );

        if (System.getProperty("myKey").equals("abc")) {
            System.out.println("!!!!!!!!!");
        }
//        System.getProperty("line.separator") = System.lineSeparator()
//        File.pathSeparator

        System.out.println(System.getenv("PATH"));

        Integer i = 1;
        int ii = i;
    }
}

class Data {
    private int i;
    private String s;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return i == data.i && Objects.equals(s, data.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, s);
    }
}