package com.serions;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void mergeArrays(int[] arr1, int[] arr2, int[] arr3) {
        int n = arr1.length;
        int m = arr2.length;

        // traverse both arrays
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            // check if current element of first array is smaller than the current element of second array
            // If yes, store first array element and increment first array index, otherwise do the same with the second array
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }

        // Store remaining elements of first array
        while (i < n) {
            arr3[k++] = arr1[i++];
        }

        // Store remaining elements of second array
        while (j < m) {
            arr3[k++] = arr2[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int n1 = arr1.length;

        int[] arr2 = {2, 4, 6, 8};
        int n2 = arr2.length;

        int[] arr3 = new int[n1+n2];

        mergeArrays(arr1, arr2, arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
