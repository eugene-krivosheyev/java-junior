package com.acme.edu;

import java.sql.SQLException;

public class Calc {
    public double divide(int i, int i1) throws DiviziobByZeroException {
        if (i1 == 0) throw new DiviziobByZeroException("");
        return ((double) i)/i1;
    }
}
