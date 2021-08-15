package com.serions.codility;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class CoinMachine {
    public static void main(String[] args) {
        /**
         * denominations: 1c, 5c, 10c, 25c, 50c, and $1.
         * getChange(5, 0.99) // should return [1,0,0,0,0,4]
         * getChange(3.14, 1.99) // should return [0,1,1,0,0,1]
         * getChange(3, 0.01) // should return [4,0,2,1,1,2]
         * getChange(4, 3.14) // should return [1,0,1,1,1,0]
         * getChange(0.45, 0.34) // should return [1,0,1,0,0,0]
         */
        System.out.println(Arrays.toString(getChange(5, 0.99)));
        System.out.println(Arrays.toString(getChange(3.14, 1.99)));
        System.out.println(Arrays.toString(getChange(3, 0.01)));
        System.out.println(Arrays.toString(getChange(4, 3.14)));
        System.out.println(Arrays.toString(getChange(0.45, 0.34)));
    }

    private static int[] getChange(double cash, double expenditure) {
        double[] denominations = {0.01, 0.05, 0.1, 0.25, 0.5, 1.00};
        int[] result = new int[denominations.length];
        double balance = cash - expenditure;
        for (int i = denominations.length - 1; i >= 0; i--) {
            result[i] = (int) (balance / denominations[i]);
            balance = BigDecimal.valueOf(balance % denominations[i]).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return result;
    }
}
