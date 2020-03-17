package com.serions.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A city consists of city blocks, represented as a grid of M*N blocks.
 * Each block represents either a building denoted by 1 or open land area by 0.
 * Adjacent blocks with value of 1 are considered clusters of buildings.
 * Diagonal blocks with value 1 are not considered part of the same cluster.
 * Amazon plans to have a Go store in each of buildings.
 * Write an algorithm to find the number of store Amazon can open in the city.
 *
 * input;
 * rows, an integer representing the number of rows in the grid.
 * column, an integer representing the number of columns in the grid.
 * grid, a two dimensional integer array representing the city.
 *
 * Output;
 * Returns a two dimensional integer array representing the city.
 *
 * Example;
 * input;
 * rows = 5
 * column = 4
 * grid =
 * 1 1 0 0
 * 0 0 1 0
 * 1 0 1 1
 * 1 1 1 1
 *
 * Output
 * 3
 * */

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
