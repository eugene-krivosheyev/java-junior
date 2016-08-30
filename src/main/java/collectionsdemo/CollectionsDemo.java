package collectionsdemo;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        Iterator<Integer> iter =  Arrays.asList(1,2,3).iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
            iter.remove();
        }
    }
}
