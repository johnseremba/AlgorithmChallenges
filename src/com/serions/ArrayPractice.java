package com.serions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int[] result = new int[arr.length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String... args) {
        int[] arr = moveZerosToEnd(new int[]{1, 0, 3, 0, 0, 0, 5, 9, 0, 0, 1});
        System.out.println(Arrays.toString(arr));
        deleteItemAt(3);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr, 3));

        int[] arr1 = {1,2,3,4};
        int[] arr2 = {1,2,3,4};
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(Arrays.compare(arr1, arr2));
        System.out.println(Arrays.mismatch(arr1, arr2));

        List<String> stringImmutableList = List.of("one", "two", "three");
        System.out.println(stringImmutableList);

        List<String> stringList = new ArrayList<>() {{
            add("one");
            add("two");
            add("three");
        }};
        stringList.add("four");
        System.out.println(stringList);
    }
}
