package demo.functional;


public class Demo {
    public static void main(String[] args) {
//        Outer.outerInstanceState ???
        Outer outer = new Outer();
        Saver saver = outer.factoryMethod();
        saver.save();
    }
}

/**
 * Top-level class
 */
class Outer {
    private int outerInstanceState = 0;

    public Saver factoryMethod() {
        class ConsoleSaver implements Saver {
            @Override
            public void save() {
                //????
            }
        }

        return new ConsoleSaver();
    }
}

interface Saver {
    void save();
}
