package demo;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

/**
 * JCSC
 * @author fkgjfbnjk
 * @since dfjgfkjhg
 */
public class Demo {
    String objectState = new String();
    static String classState = new String();

    static {
        System.out.println("Static init block");
    }

    /**
     * Logs a message.
     * @param args kgdkfgjdh
     * @see {Cla.m}
     */
    public static void main(String[] args) {
        int localVar = 0; //stack, temp, auto
        System.out.println(localVar);

        nestedMethod();

        //region MyRegion
        System.out.println("HW!!");
        System.out.println("HW!!");
        System.out.println("HW!!");
        System.out.println("HW!!");
        System.out.println("HW!!");
        //endregion
    }

    private static void nestedMethod() {
        int nestedLocalVar;
        String localStringVar = new String();
    }

    private void staticImportDemo() {
        abs(1);
        System.out.println(PI);
    }
}
