package com.serions.searching;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AmazonCluster {

    public static int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid) {
        // WRITE YOUR CODE HERE
        int[] arr = new int[rows];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            boolean isCluster = false;
            for (int j = 0; j < column; j++) {
                int k = grid.get(i).get(j);
                if (k == 1 && arr[j] == 1) {
                    isCluster = true;
                } else if (k == 1 && arr[j] == 0 && !isCluster) {
                    isCluster = true;
                    count++;
                }
                arr[j] = grid.get(i).get(j);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int columns = scan.nextInt();
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                int k = scan.nextInt();
                list.add(k);
            }
            grid.add(list);
        }
        int result = numberAmazonGoStores(rows, columns, grid);
        System.out.println(result);
    }
}
