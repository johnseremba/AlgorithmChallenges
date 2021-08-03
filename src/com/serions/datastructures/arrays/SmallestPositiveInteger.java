package com.serions.datastructures.arrays;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveInteger {
    public static void main(String[] args) {
        int result = solution(new int[]{1, 3, 6, 4, 1, 2});
        System.out.println(result);
    }

    private static int solution(int[] A) {
        if (A.length == 0) return 1;

        // Use set to check if an element has appeared
        Set<Integer> set = new HashSet<>();

        // add elements to the set
        for(int i=0; i<A.length; i++) {
            set.add(A[i]);
        }

        for (int i = 1; i < A.length; i++) {
            if(!set.contains(i)) return i;
        }
        return A.length + 1;
    }
}
