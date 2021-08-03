package com.serions.datastructures.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringLiterals {
    public static void main(String[] args) {
        String result = swap("geeks for geeks");
        System.out.println(result);
        boolean result2 =  match("abc");
        System.out.println(result2);
        boolean result3 = match("1234");
        System.out.println(result3);
        boolean result4 = match("123.4");
        System.out.println(result4);
        boolean result5 = match("123e4");
        System.out.println(result5);
    }

    // Naive approach
    private static String swapCharacters(String str) {
        StringBuilder result = new StringBuilder();
        for (String s : str.split(" ")) {
            char[] chars = s.toCharArray();
            chars[0] = s.charAt(s.length() - 1);
            chars[s.length() - 1] = s.charAt(0);
            result.append(new String(chars)).append(" ");
        }
        return result.toString().trim();
    }

    private static String swap(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int k = i;
            while (i < chars.length && chars[i] != ' ') i++;
            char temp = chars[k];
            chars[k] = chars[i - 1];
            chars[i - 1] = temp;
        }
        return new String(chars);
    }

    /**
     * Check if a given string is a valid number
     * input str = "11.5" | Output: true
     * input str = "abc" | Output: false
     * input str = "2e10" | Output: true
     */
    private static boolean match(String str) {
        // Regular expression for a floating poing integer number
        String regex = "[-+]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";

        // Compiling regex
        Pattern p = Pattern.compile(regex);

        // Matcher that will match input against regex
        Matcher m = p.matcher(str);

        // If match found and equal to input
        if (m.find() && m.group().equals(str)) {
            return true;
        } else {
            return false;
        }
    }
}
