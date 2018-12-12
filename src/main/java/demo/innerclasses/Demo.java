package demo.innerclasses;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Demo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner obj1 = outer.new Inner();
    }


}

class Outer {
    private int instanceState = 0;
    private static int classState;

    Externalizable om(Externalizable p) {
        class Inner implements Externalizable {
            @Override
            public void writeExternal(ObjectOutput out) throws IOException {
                //....
            }

            @Override
            public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

            }

            public void m() {}
        }

        return new Inner();
    }
}