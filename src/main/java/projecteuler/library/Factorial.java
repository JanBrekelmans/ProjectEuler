package projecteuler.library;

import java.math.BigInteger;

public class Factorial {
    public static BigInteger factorial(long n) {
        if(n < 0) throw new IllegalArgumentException("Argument must be positive");

        BigInteger result = BigInteger.ONE;

        for(long i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    public static BigInteger binomial(int n, int m) {
        if(m < 0 || m > n) return BigInteger.ZERO;

        return factorial(n).divide(factorial(m)).divide(factorial(n-m));
    }
}
