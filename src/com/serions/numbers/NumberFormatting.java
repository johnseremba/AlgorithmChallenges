package com.serions.numbers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatting {
    public static void main(String[] args) {
        System.out.println("formatWithStringFormat");
        formatWithStringFormat();

        System.out.println("\nformatWithBigDecimal");
        formatWithBigDecimal();

        System.out.println("\nformatWithMathRound");
        formatWithMathRound();

        System.out.println("\n----- formatting Different types of Numbers -----");

        System.out.println("\nformat lage integers with commas");
        formatWithCommas();

        System.out.println("\nPadding");
        formatWithPadding();

        System.out.println("\nformatting percentages");
        formatWithPercentages();

        System.out.println("\nformatting currency");
        formatWithCurrency();

        System.out.println("\nformatting Decimal Format");
        formatWithDecimalFormat();
    }

    private static void formatWithStringFormat() {
        double value = 4.2345298d;
        System.out.println(String.format("%.2f", value)); // 4.23
        System.out.println(String.format("%.3f", value)); // 4.235
    }

    private static void formatWithBigDecimal() {
        double value = 4.2345298d;
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP); // 4.23
        System.out.println(bigDecimal);
        bigDecimal = BigDecimal.valueOf(value).setScale(3, RoundingMode.HALF_UP); // 4.235
        System.out.println(bigDecimal);
    }

    private static void formatWithMathRound() {
        double value = 4.2345298d;
        System.out.println(withMathRound(value, 2));
        System.out.println(withMathRound(value, 3));

        // Math#round truncates the value see;
        System.out.println(withMathRound(1000.0d, 17));
        System.out.println(withMathRound(260.775d, 2));
    }

    private static double withMathRound(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    private static void formatWithCommas() {
        long value = 123456789000700L;
        DecimalFormat df = new DecimalFormat("###,###,###");
        System.out.println(df.format(value));
        System.out.println(df.format(12345));
    }

    private static void formatWithPadding() {
        int value = 1;
        System.out.println(String.format("%03d", value)); //001
    }

    private static void formatWithPercentages() {
        double value = 25f / 100f;
        NumberFormat nf = NumberFormat.getPercentInstance(Locale.US);
        System.out.println(nf.format(value));
    }

    private static  void formatWithCurrency() {
        double value = 23_500d;
        System.out.println(currencyWithChosenLocale(value, Locale.US));
        System.out.println(currencyWithChosenLocale(value, Locale.CHINA));
        System.out.println(currencyWithChosenLocale(value, Locale.UK));
        System.out.println(currencyWithChosenLocale(value, new Locale("hi", "IN")));
    }

    private static String currencyWithChosenLocale(double value, Locale locale) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        return nf.format(value);
    }

    private static void formatWithDecimalFormat() {
        double value = 23_500.98558d;
        DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance();
        System.out.println(df.format(value));

        double D = 4.2352989244d;
        System.out.println(df.format(D));

        // Specific number patterns
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        DecimalFormat df3 = new DecimalFormat("#,###,###,##0.000");
        System.out.println(df2.format(D));
        System.out.println(df3.format(D));
    }
}
