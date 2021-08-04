package com.serions.codility;

import java.util.*;

public class BankBalance {
    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{100,100,100,-10},
                new String[]{"2020-12-31", "2020-12-22", "2020-12-03", "2020-12-29"}));
    }

    private static int solution(int[] A, String[] D) {
        /**
         * A = List of transactions
         * Account empty at begining of year, 0
         * D = Dates, -ve amount === card payment else incoming transfer >= 0
         * Date is YYYY-MM-DD
         * 5 per month fee for having a card, deducted at end of month,
         * unless at least 3 payments made by card (-ve) > -100for a total of atleast 100 within that month
         * compute final balance of the account at the end of the year
         */
        if (A.length == 0) return 5 * 12;
        int accountBalance = 0;
        int cardFees = 0;

        // find account balance
        for (int i = 0; i < A.length; i++) accountBalance += A[i];

        // find card fees
        HashMap<Integer, List<Integer>> monthlyCardExpenses = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                int month = Integer.parseInt(D[i].split("-")[1]);
                if (monthlyCardExpenses.containsKey(month)) {
                    monthlyCardExpenses.get(month).add(A[i]);
                } else {
                    List<Integer> expenses = new ArrayList<>();
                    expenses.add(A[i]);
                    monthlyCardExpenses.put(month, expenses);
                }
            }
        }

        // Calculate card fees for months
        for (int i = 1; i < 13; i++) {
            if (monthlyCardExpenses.containsKey(i)) {
                List<Integer> transactions = monthlyCardExpenses.get(i);
                if (transactions.size() >= 3) {
                    // are payments over 100?
                    int sum = 0;
                    for (int j = 0; j < transactions.size(); j++) {
                        sum += transactions.get(j);
                    }
                    if (Math.abs(sum) < 100) {
                        cardFees += 5;
                    }
                } else {
                    cardFees += 5;
                }
            } else {
                cardFees += 5;
            }
        }

        // better calculation
        /* for(Map.Entry<Integer, List<Integer>> entry : monthlyCardExpenses.entrySet()) {
            if (entry.getValue().size() >= 3) {
                int sum = Math.abs(entry.getValue().stream().mapToInt(exp -> exp).sum());
                if (sum > 100) cardFees--;
            }
        }
        return accountBalance - cardFees * 5;
        */
        return accountBalance - cardFees;
    }
}
