package com.serions.core.strings;

public class StringsLesson {
    public static void main(String[] args) {
        stringManipulation();
    }

    private static void stringManipulation() {
        // Bad Example
        String alpha = "";
        for(char current = 'a'; current <= 'z'; current++)
            alpha += current;
        System.out.println(alpha);

        // Good Example
        StringBuilder alpha2 = new StringBuilder();
        for (char i = 'a'; i <= 'z' ; i++) alpha2.append(i);
        System.out.println(alpha2);

        StringBuilder sb = alpha2.insert(2, "-");
        System.out.println(sb);
        sb.delete(3, 6);
        System.out.println(sb);

        // Reverse
        StringBuilder reverse = new StringBuilder("Reverse");
        reverse.reverse();
        System.out.println(reverse);
    }
}
