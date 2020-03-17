package com.serions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RotateWords {
//    public static int shiftedDiff(String first, String second) {
//
//    }

    public static void main(String[] args) {
      List<String> s = split("John,Paul,Jonz");
      System.out.println(s.toString());
      subStrings();
    }

    // Join String arrays into one String
    public static String join(String[] arrayOfStrings) {
        return String.join(", ", arrayOfStrings);
    }

    // Join String with Prefix
    public static String joinWithPrefixPostfix(String[] arrayOfString) {
        return Arrays.stream(arrayOfString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    // Split Strings
    public static List<String> split(String str) {
        return Stream.of(str.split(","))
                .map(String::new)
                .collect(Collectors.toList());
    }

    // SubStrings
    public static void subStrings() {
        String str = "TestString";
        String subStr = str.substring(0, 1);
        System.out.println(subStr);
    }
}
