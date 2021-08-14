package com.serions.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumbers {
    public static void main(String[] args) {
        findCircularPrimeNumbers(100000);
    }

    private static void findCircularPrimeNumbers(int N) {
        // Find prime numbers
        // Use Sieve of Eratosthenes Algorithm: mark all numbers divisible by 2, and >= the square of it
        // mark all unmarked numbers which are multiples of 3 and are >= the square of it
        // mark all multiples of 5 and all multiples of 5 and are >= the square of it
        int[] primes = sieveOfEratosthenes(N);
        boolean[] isCircularPrime = new boolean[primes.length];
        Arrays.fill(isCircularPrime, true);
        for (int i = 0; i < primes.length; i++) {
            int numLen = countDigits(primes[i]);
            int temp = primes[i];
            for (int j = 0; j < numLen; j++) {
                int num = rotatePrime(temp);
                // check for all rotations of this prime number
                // if new rotation is prime, check next rotation
                // till new rotation becomes the actual prime number
                // if new rotation is not prime, then break
                if (!isPrime(num)) {
                    isCircularPrime[i] = false;
                }
                temp = num;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < isCircularPrime.length; i++) {
            if (isCircularPrime[i]) result.add(primes[i]);
        }
        System.out.println(result);
        System.out.println(result.size());
    }

    private static int[] sieveOfEratosthenes(int N) {
        List<Integer> result = new ArrayList<>();
        // Create a boolean array primer[0..n] and initialize all entries to true
        boolean[] prime = new boolean[N + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= N; p++) {
            // if prime[p] is not changed, then it is a prime
            if (prime[p]) {
                // update all multiples of p
                for (int j = p * p; j <= N; j += p) prime[j] = false;
            }
        }

        // Get all prime numbers
        for (int i = 0; i < N; i++) {
            if (prime[i]) result.add(i);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int rotatePrime(int n) {
        int rem = n % 10; // find unit place number
        rem *= Math.pow(10, countDigits(n)); // to put unit place
        n /= 10; // remove unit digit
        n += rem; // add first digit to rest
        return n;
    }

    private static int countDigits(int n) {
        int digit = 0;
        while ((n /= 10) > 0) digit++;
        return digit;
    }

    private static boolean isPrime(int n) {
        // Corner case
        if (n < 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
