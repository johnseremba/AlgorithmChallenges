package com.serions;

import java.util.Arrays;

public class ArrayPractice {
    static int[] moveZerosToEnd(int[] arr) {
        // your code goes here
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }

    static void deleteItemAt(int position) {
        int[] arr = new int[] {8,9,0,1,2,3,4,5};
        int n = arr.length;
        int j = position;

        while (j < n) {
            arr[j - 1] = arr[j];
            j++;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = moveZerosToEnd(new int[]{1, 0, 3, 0, 5, 9, 0, 0, 1});
        System.out.println(Arrays.toString(arr));
    }
}
