package com.serions.codility;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(getBinaryGap(529));
    }

    private static int getBinaryGap(int N) {
        int max_gap = 0;
        int current_gap = 0;
        boolean counting = false;

        // bit manipulation and "& operation
        while(N != 0) {
            if (!counting) {
                if ((N&1) == 1) {
                    counting = true;
                }
            } else {
                if ((N&1) == 0) {
                    current_gap++;
                } else {
                    max_gap = Math.max(max_gap, current_gap);
                    current_gap = 0; // reset
                }
            }
            N = N >> 1; // shift by one
        }
        return max_gap;
    }
}
