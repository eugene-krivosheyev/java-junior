package demo.functional;


public class Demo {
    public static void main(String[] args) {
//        Outer.outerInstanceState ???
        Outer outer = new Outer();
        Saver saver = outer.factoryMethod();
        saver.save("", "");

        new MyLogger(
            (p, severity) -> outer.doThm(p)
        );


    }
}

/**
 * Top-level class
 */
class Outer {
    private int outerInstanceState = 0;

    public Saver factoryMethod() {
        int outerMethodLocalVar = 0;

       return new Saver() {
           @Override //Closure
           public void save(String message, String severity) {
               Outer.this.outerInstanceState = 1;
               System.out.println(outerMethodLocalVar);
//               outerMethodLocalVar = 5;
           }
       };
    }


    void doThm(String p) {

    }
}

@FunctionalInterface
interface Saver {
    //Closure
    void save(String message, String severity);
}

class MyLogger {
    private Saver saver;

    MyLogger(Saver saver) {
        this.saver = saver;
    }
}