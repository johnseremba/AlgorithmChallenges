package com.serions.codility;

import java.util.ArrayList;
import java.util.List;

public class PokerChips {
    public static void main(String[] args) {
        buyChips(273);
    }

    private static void buyChips(int n) {
        int[] chips = new int[]{100, 50, 25, 10, 5, 1};
        List<Integer> result = new ArrayList<>();
        while (n > 0) {
            for (int i = 0; i < chips.length; i++) {
                while(n / chips[i] >= 1) {
                    result.add(chips[i]);
                    n -= chips[i];
                }
            }
        }
        System.out.println(result);
    }
}
