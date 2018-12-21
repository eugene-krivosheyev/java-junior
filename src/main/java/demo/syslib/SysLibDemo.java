package demo.syslib;

import java.util.Properties;

public class SysLibDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        //region system & runtime
        Properties properties = System.getProperties();
        for (String pn: properties.stringPropertyNames()) {
            System.out.print(pn + " : ");
            System.out.println(properties.getProperty(pn));
        } //java -Dfile.encoding=Cp866

//        System.arraycopy();
//        System.load("file.so"); //JNI | JNA |
        System.gc();
//        Runtime.getRuntime().exec("ls");

        Object o = new Object();
        System.out.println(o);

        Cat cat = new Cat("Murik");
        Cat clone = (Cat)cat.clone();
        System.out.println(clone.getName());

        System.exit(-1);
        //endregion
    }
}

class Cat implements Cloneable {
    private Cat friend;
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}