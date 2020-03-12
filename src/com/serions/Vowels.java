package com.serions;

import java.util.Arrays;
import java.util.List;

public class Vowels {
    public static int findVowels(String input) {
        List<Character> vowelsList = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for(char ch: input.toCharArray()) {
          if (vowelsList.contains(ch)) {
              count++;
          }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findVowels("'helloworld'"));
    }
}
