package com.serions.searching;

import java.util.Arrays;

public class HeapSort {
    // To heapify a subtree rooted with node index, which is an index in arr[]. size is the size of the heap
    private static void heapify(int[] arr, int size, int index) {
        int largest = index; //initialize largest as root
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // If left child is larger than root
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, size, largest);
        }
    }

    private static void sort(int[] arr) {
        int n = arr.length;

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from the heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 15, 6, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
