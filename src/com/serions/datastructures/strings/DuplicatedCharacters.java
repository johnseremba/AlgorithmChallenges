package com.serions.datastructures.strings;

import java.util.HashMap;
import java.util.Map;

public class DuplicatedCharacters {
    public static void main(String[] args) {
        System.out.println(findMostDuplicated("hello world"));
    }

    private static char findMostDuplicated(String str) {
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : chars) {
            if (ch == ' ') continue;
            if (map.containsKey(ch)) {
                int value = map.get(ch);
                map.put(ch, ++value);
                continue;
            }
            map.put(ch, 1);
        }
        char d = chars[0];
        for (Map.Entry<Character, Integer> ch: map.entrySet()){
            if (ch.getValue() > map.get(d)) {
                d = ch.getKey();
            }
        }
        return d;
    }
}
