package com.serions.datastructures.arrays;

import java.util.Arrays;

public class ArrayRearrange {
    public static void main(String[] args) {
        rearrange(new int[]{-1, -1, 6, 1, 9, 3, 2, -1, 4, -1});
    }

    /**
     * Algorithm to rearrange an array such that arr[i] = i
     * https://www.geeksforgeeks.org/rearrange-array-arri/
     * @param arr
     */
    private static void rearrange(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] != i) { // i = 2, arr[i] = 6, arr[arr[i]] = 2
                int temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
