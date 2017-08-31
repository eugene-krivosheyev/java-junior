package com.acme.edu.innerclasse;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class InnerClassesDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Externalizable m = outer.new Inner().m();
        outer.new Inner().new InnerInnerClass();
    }
}


class Outer {
    private int outerState;
    protected class Inner {

        class InnerInnerClass {
            void m() {
                System.out.println(outerState);
                System.out.println(Outer.this.outerState);
            }
        }

        Externalizable m() {
            System.out.println(outerState);

            return new Externalizable() {
                @Override
                public void writeExternal(ObjectOutput out) throws IOException {

                }

                @Override
                public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

                }
            };
        }
    }
}