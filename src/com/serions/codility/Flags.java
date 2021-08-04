package com.serions.codility;

import java.util.ArrayList;
import java.util.List;

public class Flags {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,5,3,4,3,4,1,2,3,4,6,2}));
    }

    private static int solution(int[] A) {
        /**
         * {1,5,3,4,3,4,1,2,3,4,6,2} // Relative Heights
         * {0,1,2,3,4,5,6,7,8,9,10,11}
         * peaks = {1,3,5,10} => {5,4,4,6}
         * dist  = {5-4=>1, 4-4=>0, 4-6=>2} =>{1,0,2} =>{2,2,5}
         * Given (index P)
         * P > 0
         * P < N -1, where N is the total number of elements in the array
         * A[P] > A[P -1] && A[P] > A[P + 1], this is the peak
         * Flags can only be set on peaks
         * Distance between any two flags >= K, where K is the number of flags
         * K can be >= 0
         * |P - Q| is the distance between indices
         * The function should return 3, the maximum number of flags that can be set on the peaks
         */

        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i-1] < A[i] && A[i] > A[i+1]) {
                peaks.add(i);
            }
        }

        // Check the number of blocks
        int N = A.length;
        for (int j = N; j > 0; j--) {
            if (N%j == 0) {
                int blockSize = N/j;
                int block = 0;
                // test peaks
                for (int k : peaks) {
                    if(k/blockSize == block) {
                        block++;
                    }
                }
                if(block == j) return j;
            }
        }
        return 0;
    }
}
