package com.serions.datastructures.arrays;

import java.util.Arrays;

public class ArrayRearrange {
    public static void main(String[] args) {
        reverseArray(new int[]{1,2,3});
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

    /**
     * Algorithm to reverse an array
     * https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
     * @param arr
     */
    private static void reverseArray(int[] arr) {
        int j = arr.length - 1;
        for (int i = 0; i < j; i++) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            j--;
        }

        System.out.println(Arrays.toString(arr));
    }
}
