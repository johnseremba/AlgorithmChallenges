package com.serions.datastructures.arrays;

import java.util.*;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int result = occurrences(new int[]{9, 3, 9, 3, 9, 7, 9});
        System.out.println(result);
        int result2 = solution(new int[]{9, 3, 9, 3, 9, 7, 9});
        System.out.println(result2);
    }
    
    private static int occurrences(int[] A) {
        int n = A.length;
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (occurrenceMap.containsKey(A[i])) {
                int occurrence = occurrenceMap.get(A[i]);
                occurrenceMap.put(A[i], ++occurrence);
            } else {
                occurrenceMap.put(A[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : occurrenceMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // XOR Solution
    private static int solution(int[] A) {
        // Using the concept of "XOR" (^)
        // when there is a pair A and B
        // A^B will be zero
        // A^B^C (where C is not paired),
        // then A^B^C = C

        if (A.length == 0) return 0;
        int unpaired = A[0]; // initial
        for (int i = 1; i < A.length; i++) {
            unpaired = unpaired ^ A[i];
        }
        return unpaired;
    }
}
