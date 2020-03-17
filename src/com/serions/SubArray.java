package com.serions;

import java.util.Scanner;

/**
 * We define the following:
 * <p>
 * A subarray of an -element array is an array composed from a contiguous block of the original array's elements.
 * For example, if array = [1,2,3],
 * then the subarrays are [1], [2], [3], [1,2], [2,3] and [1,2,3,].
 * Something like [1,3] would not be a subarray as it's not a contiguous subsection of the original array.
 * <p>
 * The sum of an array is the total sum of its elements.
 * An array's sum is negative if the total sum of its elements is negative.
 * An array's sum is positive if the total sum of its elements is positive.
 * Given an array of  integers, find and print its number of negative subarrays on a new line.
 * <p>
 * Input Format
 * <p>
 * The first line contains a single integer,n , denoting the length of array .
 * The second line contains n space-separated integers describing each respective element, ai , in array A.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print the number of subarrays of  having negative sums.
 * <p>
 * Sample Input
 * <p>
 * 5
 * 1 -2 4 -5 1
 * Sample Output
 * <p>
 * 9
 */

public class SubArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scan.next());
        }
        int counted = getSubArrays(arr, n);
        System.out.println(counted);
    }
    
    private static void optimalSolution() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        int result = 0;
        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
            int sum = arr[i];
            if (sum < 0) result++;
            for (int j=i-1; j>=0; j--) {
                sum += arr[j];
                if (sum < 0) result++;
            }
        }
        System.out.println(result);
    }

    private static int getSubArrays(int[] arr, int n) {
        int numOfSubArrays = n * (n + 1) / 2;
        int first = 0;
        int gf = 0;
        int count = 0;
        while (numOfSubArrays > 0) {
            int last = first + gf;
            if (last > n - 1) {
                first = 0;
                gf++;
                last = first + gf;
            }
            int sum = getSubSetsSum(arr, first, last);
            if (sum < 0) {
                count++;
            }
            first++;
            numOfSubArrays--;
        }
        return count;
    }

    private static int getSubSetsSum(int[] arr, int first, int last) {
        int sum = 0;
        for (int i = first; i <= last; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
