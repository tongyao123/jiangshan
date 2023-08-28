package com.example.jiangshan.function;

public class NumericalConversion {
    public static Integer LongToInteger(Object numrice) {

        if (numrice.equals("") || numrice==null || numrice.equals(0)){
            return 0;
        }
        if (numrice instanceof Double) {
            Double d = (double) numrice;

            return d.intValue();
        } else {
            return Integer.parseInt(numrice.toString());
        }
    }
}
