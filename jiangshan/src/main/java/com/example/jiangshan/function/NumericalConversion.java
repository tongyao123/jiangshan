package com.example.jiangshan.function;

public class NumericalConversion {
    public static Integer LongToInteger(Object numrice) {
        if (numrice instanceof Double) {
            Double d = (double) numrice;
            return d.intValue();
        } else {
            return Integer.parseInt(numrice.toString());
        }
    }
}
