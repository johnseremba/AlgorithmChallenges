package com.serions.codility;

import java.util.*;

public class MaxWordsInSentance {
    public static void main(String[] args) {
        System.out.println(solution("We test coders! Give us a try?"));
        System.out.println(solution(""));
    }

    private static int solution(String S) {
        if (S.length() < 1) return 0;
        String[] sentences = S.split("\\.|\\?|!");
        HashMap<Integer, Integer> wordCount = new HashMap<>();
        for (int i=0; i<sentences.length; i++) {
            if (sentences[i].equals(" ")) continue;
            String[] words = sentences[i].replaceAll("\\s{2,}", " ").trim().split(" ");
            wordCount.put(i, words.length);
        }
        int maxWords = wordCount.get(0);
        for (Map.Entry<Integer, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxWords) {
                maxWords = entry.getValue();
            }
        }
        return maxWords;
    }
}
