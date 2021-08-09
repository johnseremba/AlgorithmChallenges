package com.serions.core.strings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class StringsLesson {
    public static void main(String[] args) {
//        stringManipulation();
        stringFormatting();
    }

    private static void stringManipulation() {
        // Bad Example
        String alpha = "";
        for(char current = 'a'; current <= 'z'; current++)
            alpha += current;
        System.out.println(alpha);

        // Good Example
        StringBuilder alpha2 = new StringBuilder();
        for (char i = 'a'; i <= 'z' ; i++) alpha2.append(i);
        System.out.println(alpha2);

        StringBuilder sb = alpha2.insert(2, "-");
        System.out.println(sb);
        sb.delete(3, 6);
        System.out.println(sb);

        // Reverse
        StringBuilder reverse = new StringBuilder("Reverse");
        reverse.reverse();
        System.out.println(reverse);
    }

    private static void stringFormatting() {
        Object[] stringArr = new String[]{"one", "two", "three", "four"};
        String argIndex = String.format("%3$s", stringArr);
        System.out.println(argIndex);

        String output = String.format("%s = %d", "serry", 35);
        System.out.println(output);

        StringBuilder builder = new StringBuilder();
        Formatter formatter = new Formatter(builder);
        formatter.format("PI = %f%n", Math.PI);
        System.out.println(builder.toString());

        String str = String.format("|%10d|", 95);
        System.out.println(str);

        String str2 = String.format("|%-10d|", 97);
        System.out.println(str2);

        String str3 = String.format("|%03d|", 1);
        System.out.println(str3);

        String str4 = String.format("%,d", 3007008);
        System.out.println(str4);

        String str5 = String.format("%(d", 78);
        System.out.println(str5);

        String str6 = String.format("%x", 93);
        System.out.println(str6);

        // Max number of characters
        String str7 = String.format("|%10.7s|", "Hello world!");
        System.out.println(str7);


        // Date Time Formatting
        System.out.printf("%tA%n", new Date()); // Prints day of the week
        System.out.printf("%ta%n", new Date()); // Prints abbrev name of the week
        System.out.printf("%tB%n", new Date()); // Prints abbrev name of the month

        String dateString = "Thu, Dec 31 1998 23:37:50";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(dateString);
            System.out.println(date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
