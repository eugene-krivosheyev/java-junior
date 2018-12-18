package demo.genericsdemo;

public class Demno {
    public static void main(String[] args) {
        Object o1 = "";
        if (o1 instanceof String) {
            (String)o1
        }
        (String)MySuperComparator.compareTo()
    }
}

class MySuperComparator {
    public static Object compareTo(Object o1, Object o2) {
        return 0;
    }
}
