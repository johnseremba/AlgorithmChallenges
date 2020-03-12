package com.serions;

import java.util.Scanner;

public class FizzBuzz {
    public static String fizzBuzz(int input) {
        return (input % 3 == 0 && input % 5 == 0) ? "fizzbuzz"
                : input % 3 == 0 ? "fizz"
                : input % 5 == 0 ? "buzz"
                : Integer.toString(input);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println(fizzBuzz(i));
        }
    }
}
