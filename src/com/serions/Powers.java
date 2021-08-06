package com.serions;

public class Powers {
    public static void main(String[] args) {
        System.out.println(power(10,-3));
    }
    private static double power(int x, int y) {
        boolean isNegativeExponent = y < 0;
        int result = 1;
        for (int i = 0; i < Math.abs(y); i++) {
            result *= x;
        }
        if (isNegativeExponent) return (double) 1 / result;
        return result;
    }
}
