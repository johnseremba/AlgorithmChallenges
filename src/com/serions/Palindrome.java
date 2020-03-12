package com.serions;

import java.util.Scanner;

public class Palindrome {
    private static boolean isPalindrome(String input) {
        return input.equalsIgnoreCase(new StringBuilder()
                .append(input)
                .reverse()
                .toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(isPalindrome(in.nextLine()));
    }
}
