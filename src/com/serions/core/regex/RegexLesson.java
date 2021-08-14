package com.serions.core.regex;

public class RegexLesson {
    public static void main(String[] args) {
        /**
         * . => Matches any character
         * ^regex => finds a match at the beginning of the line
         * regex$ => finds a match at the end of the line
         * [abc] => can match the letters a, b or c
         * [abc][vz] => can match a or b or c followed by either v or z
         * [^abc] => when the carret appears in the brackets, it negates the pattern. So this matches any characters apart from a, b or c
         * [a-d1-7] => Ranges; matches a letter between a and d and figures from 1 to 7 but not d1
         * X|Z => Finds X or Z
         * XZ => Finds X directly followed by Z
         * $ => checks if a line end follows
         * // Quantifier
         * A quantifier defines how often an element can occur. the symbols are; ? * + {}
         * * => occurs zero ore more times {0, }
         * + => occurs one or more times {1, }
         * ? => occurs no or one time, {0, 1}
         * {X} => Occurs X number of times e.g; \d{3} -- searches for 3 digits, .{10} -- for any character of sequence > 10
         * {X, Y} Occurs between X and Y
         * *? => makes a reluctant qualifier, makes the regular expression stop at the first match
          */
    }
}
