package com.serions.datastructures.arrays;

import java.util.Arrays;

public class ArraysRotation {
    public static void main(String[] args) {
        rotate(new int[]{3, 8, 9, 7, 6}, 3, 5);
        rotateRight(new int[]{3, 8, 9, 7, 6}, 3);
    }

    /** A function that rotates an array arr[] of size n by d elements
     * https://www.geeksforgeeks.org/array-rotation/
     * @param arr
     * @param d
     * @param n
     */
    private static void rotate(int[] arr, int d, int n) {
        if (arr.length < 1) return;
        for (int i=0; i<d; i++) {
            int temp = arr[0];
            for(int j=0; j<n-1; j++) {
                arr[j] = arr[j+1];
            }
            arr[n-1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void rotateRight(int[] arr, int d) {
        if (arr.length < 1) return;
        int n = arr.length;
        for (int i=0; i<d; i++) {
            int temp = arr[n - 1];
            for(int j=n-1; j>0; j--) {
                int temp2 = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp2;
            }
            arr[0] = temp;
            System.out.println("Rotation " + i + ": " + Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }
}
