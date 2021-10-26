package demo;

public class InnerClassesDemo {
    public static void main(String[] args) {
        TopLevel.Inner object = new TopLevel.Inner();
        object.m();
    }
}

class TopLevel {
    private static int classState;
    private int instanceState;

    static class Inner {
        public void m() {
            classState = 1;
        }
    }
}
