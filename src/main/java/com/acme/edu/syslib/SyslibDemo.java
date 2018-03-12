package com.acme.edu.syslib;

import java.lang.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

//        "fffffff 6 4 yyyy 6 uuuu".split("^f*[1..9]*(u+)\[:word]?+");
//        Pattern, Matcher

        System.out.println("1" + "2" + "3" + "4");
        new StringBuilder("1")
                .append("2")
                .append("3");

        Integer i = new Integer(5);
        int ii = i;
        Integer.valueOf("lkjkjkj");

        System.out.println(Double.parseDouble("-2e+7"));

        //Performance issue
        for (Integer counter = 0; counter < 10; counter++) {
            System.out.println(counter);
        }

        Integer i1 = 1, i2 = 1; //intern
        System.out.println(i1 == i2);
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
