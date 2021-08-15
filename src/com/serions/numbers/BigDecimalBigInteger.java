package com.serions.numbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

public class BigDecimalBigInteger {
    public static void main(String[] args) {
        BigDecimal bdFromString = new BigDecimal("0.1");
        System.out.println(bdFromString);

        BigDecimal bdFromCharArray = new BigDecimal(new char[] {'3', '.', '1', '6','5'});
        System.out.println(bdFromCharArray);

        BigInteger bigInteger = BigInteger.probablePrime(6, new Random());
        System.out.println(bigInteger);

        // We should use a string constructor instead of a double constructor
        BigDecimal bdFromDouble = new BigDecimal(0.1d);
        System.out.println(bdFromDouble);

        BigDecimal bdFromDouble2 = BigDecimal.valueOf(0.1d);
        System.out.println(bdFromDouble2);

        // Operations on BigDecimal
        System.out.println("\nOperations on Big Decimal");
        BigDecimal value = new BigDecimal("-12345.6789");
        System.out.println(value.precision());
        System.out.println(value.scale());
        System.out.println(value.signum());

        // Compare
        System.out.println("\nComparision");
        System.out.println(value.compareTo(bdFromDouble));

        // Arithmetic
        System.out.println("\nArithmetic");
        BigDecimal bd1 = new BigDecimal("4.0");
        BigDecimal bd2 = new BigDecimal("2.0");

        BigDecimal sum = bd1.add(bd2);
        BigDecimal difference = bd1.subtract(bd2);
        BigDecimal quotient = bd1.divide(bd2);
        BigDecimal product = bd1.multiply(bd2);

        System.out.println("sum: " + sum);
        System.out.println("difference: " + difference);
        System.out.println("quotient: " + quotient);
        System.out.println("product: " + product);

        // Rounding
        System.out.println("\nRounding------");
        BigDecimal bd = new BigDecimal("2.5");
        System.out.println(bd.round(new MathContext(1, RoundingMode.HALF_EVEN)));
        System.out.println(bd.round(new MathContext(1, RoundingMode.HALF_UP)));
        System.out.println(bd.round(new MathContext(1, RoundingMode.HALF_DOWN)));
        System.out.println(bd.round(new MathContext(1, RoundingMode.UP)));

        System.out.println("--------");
        BigDecimal bdNew = new BigDecimal("2.5345456");
        System.out.println(bdNew.round(new MathContext(3, RoundingMode.HALF_EVEN)));
        System.out.println(bdNew.round(new MathContext(3, RoundingMode.HALF_UP)));
        System.out.println(bdNew.round(new MathContext(3, RoundingMode.HALF_DOWN)));
        System.out.println(bdNew.round(new MathContext(3, RoundingMode.UP)));

        System.out.println("--------");
        BigDecimal bdNew2 = new BigDecimal("260.5345456");
        System.out.println(bdNew2.setScale(2, RoundingMode.HALF_EVEN));
        System.out.println(bdNew2.setScale(2, RoundingMode.HALF_UP));
        System.out.println(bdNew2.setScale(2, RoundingMode.HALF_DOWN));
        System.out.println(bdNew2.setScale(2, RoundingMode.UP));

        System.out.println("\nBing Integer--------");
        BigInteger bigInteger1 = BigInteger.valueOf(1234567890987654321L);
        System.out.println(bigInteger1);

        // GCD
        BigInteger i = BigInteger.valueOf(31);
        BigInteger j = BigInteger.valueOf(24);
        BigInteger k = BigInteger.valueOf(16);

        BigInteger gcd = j.gcd(k);
        System.out.println(gcd);

        BigInteger multiplyAndMod = j.multiply(k).mod(i);
        System.out.println(multiplyAndMod);

        BigInteger modInverse = j.modInverse(i);
        System.out.println(modInverse);

        BigInteger modPow = j.modPow(k, i);
        System.out.println(modPow);

        BigInteger isProbablePrime = BigInteger.probablePrime(100, new Random());
        System.out.println(isProbablePrime);
        System.out.println(isProbablePrime.isProbablePrime(1000));
    }
}
