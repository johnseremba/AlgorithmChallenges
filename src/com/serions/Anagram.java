package com.serions;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static HashMap<Character, Integer> buildHashMap(String input) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            int count = 1;
            char currentChar = input.toLowerCase().charAt(i);
            if (hashMap.containsKey(currentChar)) {
                count = hashMap.get(currentChar) + 1;
            }
            hashMap.put(currentChar, count);
        }
        return hashMap;
    }

    public static boolean isAnagram(String strA, String strB) {
        HashMap<Character, Integer> hashMapA = buildHashMap(strA);
        HashMap<Character, Integer> hashMapB = buildHashMap(strB);

        if (hashMapA.size() != hashMapB.size()) {
            return false;
        }

        for (Map.Entry element : hashMapA.entrySet()) {
            Character character = (Character) element.getKey();
            int count = (int) element.getValue();
            if (hashMapB.containsKey(character) && hashMapB.get(character) != count) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = isAnagram("friend", "Friend");
        System.out.println(result);
    }
}
