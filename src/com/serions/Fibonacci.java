package com.serions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {
    public static int fibonacci(int num) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0,1));
        for (int i = 2; i <= num; i++) {
            int prevNum1 = result.get(i - 1);
            int prevNum2 = result.get(i - 2);
            result.add(prevNum1 + prevNum2);
        }
        return result.get(num);
    }

    public static int fibonacciRecursive(int num) {
        if (num < 2) {
            return num;
        }

        return fibonacciRecursive(num - 1) + fibonacciRecursive(num - 2);
    }

    public static void main(String[] args) {
        int result = fibonacciRecursive(8);
        System.out.println(result);
    }
}
