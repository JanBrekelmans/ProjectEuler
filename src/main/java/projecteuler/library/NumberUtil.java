package projecteuler.library;

import java.math.BigInteger;
import java.util.Arrays;

public class NumberUtil {
    public static int integerSquareRoot(int n) {
        if(n < 0) throw new IllegalArgumentException("Negative number");
        int r = 0;
        for(int i = 1<<15; i > 0; i= i>>>1) {
            r |= i;

            if(r*r > n || r > 46340) r ^= i;
        }
        return r;
    }

    public static long integerSquareRoot(long n) {
        if(n < 0){
            throw new IllegalArgumentException("Negative number");
        }
        long r = 0;
        for(int i = 1<<31; i != 0; i= i>>>1) {
            r |= i;

            if(r*r > n || r > 3037000499L ) r ^= i;
        }
        return r;
    }

    public static BigInteger integerSquareRoot(BigInteger n) {
        if(n.signum() == -1) {
            throw new IllegalArgumentException("Negative number");
        }
        BigInteger y = BigInteger.ZERO;
        for(int i = (n.bitLength()-1)/2; i >= 0; i--) {
            y = y.setBit(i);
            if(y.multiply(y).compareTo(n) > 0) {
                y = y .clearBit(i);
            }
        }
        return y;
    }

    public static long gcd(long a, long b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public static long gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}
