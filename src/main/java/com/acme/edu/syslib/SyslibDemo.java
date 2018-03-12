package com.acme.edu.syslib;

import java.lang.*;
import java.util.Objects;

public class SyslibDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        try {
            ((My)new My(0).clone()).toString();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

//        My o1 = new My(1);
//        My o2 = new SubclassOfMy(1);
//        o1.equals(o2);
//        o2.equals(o1);

    }
}

class My extends Object implements Cloneable {
    private int iState;
    private boolean bState;
    private double dState;
    private My rState;


    My(int field) {
        this.iState = field;
    }

    public native void m();

    @Override
    public void finalize() throws Throwable {
        new My(iState);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Symmetry
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        My my = (My) o;

        if (iState != my.iState) return false;
        if (bState != my.bState) return false;
        if (Double.compare(my.dState, dState) != 0) return false;
        return rState != null ? rState.equals(my.rState) : my.rState == null;
    }

    /**
     * Contract JLS:
     * a equals b -> a.hc == b.hc
     * a.hc == b.hc !-> a equals b
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = iState;
        result = 31 * result + (bState ? 1 : 0);
        temp = Double.doubleToLongBits(dState);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (rState != null ? rState.hashCode() : 0);
        return result;
    }
}
