package demo.syslib;

import java.util.Properties;

public class SysLibDemo {
    public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException {
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

        Class.forName("Cat");
        cat.getClass().getAnnotations();
        //ByteBuddy | CodeAssist | ASM

        System.exit(-1);
        //endregion
    }
}


@MyAnnotation()
@SuppressWarnings({"unchecked"})
class Cat implements Cloneable {
    private Cat friend;
    private String name;

    public Cat(String name) {
        this.name = name;
    }

//    @Retry(kjghdkfgjh)
    public String getName() {
        return name;
    }

//    @Transaction
//    @RolewAllowes
    @Override
    @Deprecated
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (friend != null ? !friend.equals(cat.friend) : cat.friend != null) return false;
        return name != null ? name.equals(cat.name) : cat.name == null;
    }

    @Override
    public int hashCode() {
        int result = friend != null ? friend.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}