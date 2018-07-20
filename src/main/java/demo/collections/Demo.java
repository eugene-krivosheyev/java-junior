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
        list.get(10);
    }
}
