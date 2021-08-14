package com.serions.codility;

import java.util.Locale;

public class CalculateAccountBalance {
    public static void main(String[] args) {
        String[][] input = {{"1", "Deposit", "5.00", ""}, {"3", "Food", "", "4.01"}, {"3", "Cab", "", "0.98"}, {
                "4", "Deposit", "3.14", ""}, {"4", "Food", "", "1.99"}, {"5", "Food", "", "2.00"}, {"6", "Deposit", "4.84", ""}, {
                "7", "Food", "", "3.14"}, {"7", "Bus", "", "0.41"}, {"7", "Bus", "", "0.34"},};
        String result = solution(input);
        System.out.println(result);
    }

    private static String solution(String[][] input) {
        Locale.setDefault(Locale.US);
        StringBuilder result = new StringBuilder();
        double availableBalance = 0;
        for (int i = 0; i < input.length; i++) {
            int txId = Integer.parseInt(input[i][0]);
            String desc = input[i][1];
            if (desc.equalsIgnoreCase("deposit")) {
                double deposit = Double.parseDouble(input[i][2]);
                availableBalance += deposit;
                result.append(String.format("%d %s %.2f %.2f", txId, desc, deposit, availableBalance));
            } else {
                double expense = Double.parseDouble(input[i][3]);
                availableBalance -= expense;
                result.append(String.format("%d %s %.2f %.2f", txId, desc, expense, availableBalance));
            }
            result.append(System.lineSeparator());
        }
        result.append("Final balance: ").append(String.format("%.2f", availableBalance));
        return result.toString();
    }
}
