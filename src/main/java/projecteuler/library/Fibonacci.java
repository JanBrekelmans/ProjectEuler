package projecteuler.library;

import java.math.BigInteger;

public class Fibonacci {
    public static class FibonacciGenerator {
        BigInteger a = BigInteger.ONE,b = BigInteger.TWO;

        private void update() {
            BigInteger temp = b;
            b = b.add(a);
            a = temp;
        }

        public BigInteger getNextNumber() {
            BigInteger temp = a;
            b = a.add(b);
            update();
            return temp;
        }
    }
}
