package demo;

import java.io.Serializable;

public class EncapsulationDemo {
    public static void main(String[] args) {
        A obj = new B(); // IS-A : implements | extends

        try {
            Object o = obj.m(0); // virtual | dynamic
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 1MSLoC
    }
}


class A implements Serializable {
    Object m(int p) throws Exception {
        return null;
    }
}

class B extends A {
    @Override
    protected String m(int p) throws Exception { // -> overrides A.m()
        return null;
    }
}