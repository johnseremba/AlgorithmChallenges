package com.serions.core.bitwise;

public class BitwiseLesson {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        System.out.println("a&b = " + (a & b));
        System.out.println("a|b = " + (a|b));
        System.out.println("a^b = " + (a^b));
        System.out.println("~a = " + ~a);

        int x = 0B0110;
        int y = 0B0101;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("x&y = " + (x&y));
        System.out.println("1 & 0 = " + (1 & 0));
        System.out.println("1 & 1 = " + (1 & 1));

        // Shift Operations
        // These operators are used to shift the bits of a number left or right, thereby multiplying or dividing
        // the number by two respectively. Generally used when we have to multiply or divide a number by two
        // Signed Right shift operator (>>)-
        System.out.println("x>>1 = " + (x>>1));
        System.out.println("x<<1 = " + (x<<1));

        // Unsigned Right shift operator (>>>)-
        // Shifts the bits of the number ot the right and fills 0 on voids left as a result
        // The leftmost bit is set to 0
        System.out.println("x>>>1 = " + (x>>>1));
        System.out.println("-6>>>1 = " + (-6>>>1));
    }
}
