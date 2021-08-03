package com.serions.datastructures.strings;

public class StringLiterals {
    public static void main(String[] args) {
        String result = swap("geeks for geeks");
        System.out.println(result);
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
        for(int i = 0; i < chars.length; i++) {
            int k = i;
            while(i < chars.length && chars[i] != ' ') i++;
            char temp = chars[k];
            chars[k] = chars[i - 1];
            chars[i - 1] = temp;
        }
        return new String(chars);
    }
}
