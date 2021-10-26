package demo;

public class InnerClassesDemo {
    public static void main(String[] args) {
        final TopLevel topLevel = new TopLevel();
        TopLevel.Inner inner = topLevel.new Inner();

        TopLevel.Inner innerWithOnlyOuter = new TopLevel().new Inner();
        innerWithOnlyOuter.m();
    }
}

class TopLevel {
    private static int classState;
    private int instanceState;

    class Inner {
        public void m() {
            classState = 1;
            TopLevel.this.instanceState = 1;
        }
    }

    public Saver m() {
        class MethodClass implements Saver {
            @Override
            public void save() {
                //!!!!!!
            }
        }

        return new MethodClass();
    }

}

interface Saver {
    void save();
}