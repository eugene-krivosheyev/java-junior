package demo.syslib;

import java.io.File;
import java.util.Objects;
import java.util.Properties;
import java.util.function.BiConsumer;

public class Demo {
    public static void main(String[] args) {
//        System.exit(0);
//        System.arraycopy();
        System.currentTimeMillis(); System.nanoTime();
        System.gc();
        System.getenv();

        for (String arg : args) {
            System.out.println(arg);
        }

        Properties properties = System.getProperties();//k=v
//        properties.load();
//        properties.get
        properties.forEach((k, v) -> System.out.println(k + " : " + v));
//        System.lineSeparator();
//        File.pathSeparator
//        File.separator
        //java -Dfile.encoding=cp866 MyApp

//        Runtime.getRuntime().exec("format c:");

        Cat cat1 = new Cat(1, "M");
        Cat cat2 = new Cat(2, "B");
        cat1.equals(cat2);
        Objects.equals(cat1,cat2);

        try {
            Object cloned = cat1.clone();
            if (cloned instanceof Cat) {
                Cat clonedCat = (Cat) cloned;
                System.out.println(clonedCat.getId());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }



        Integer i = new Integer(5);
        Integer.parseInt("5");
        i.intValue();

        Integer boxedI = 5; //new Integer(5);
        int unboxedI = boxedI; //boxedI.xxxValue();

        String s = "sss"; //new String() + intern

        Integer boxedI1 = 128; //new Integer(1_000)
        Integer boxedI2 = 128; // -128..127
        System.out.println(boxedI1 == boxedI2);
        System.out.println(boxedI1.equals(boxedI2));

        //DON'T!!!!!!!
        for (Integer c = 0; c < 1_000; c++) {

        }

    }
}

class Cat implements Cloneable {
    private int id;
    private String name;

    public Cat(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (id != cat.id) return false;
        return name != null ? name.equals(cat.name) : cat.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
