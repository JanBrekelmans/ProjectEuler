package projecteuler.problem021_030;

import projecteuler.SolutionTemplate;
import projecteuler.library.PrimeUtil;

public class Problem027 implements SolutionTemplate {
    private final int UPPER_PRIME_LIMIT = 1000 * 1000 + 1000 * 1000 + 1000;
    private final boolean[] PRIME_SIEVE = PrimeUtil.primeSieve(UPPER_PRIME_LIMIT);

    public static void main(String[] args) {
        System.out.println(new Problem027().getSolution());
    }

    @Override
    public String getSolution() {
        int largestValue = 1000 * 1000 + 1000 * 1000 + 1000;
        boolean[] primeSieve = PrimeUtil.primeSieve(largestValue);

        int maxConsecutivePrimes = 0;
        int product = 0;
        for (int a = -999; a < 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {
                if(getNumberOfConsecutivePrimes(a,b) > maxConsecutivePrimes) {
                    maxConsecutivePrimes = getNumberOfConsecutivePrimes(a,b);
                    product = a*b;
                }
            }
        }

        return Integer.toString(product);
    }

    private int getNumberOfConsecutivePrimes(int a, int b) {
        int n = 0;
        while (n*n + a*n + b > 1 && PRIME_SIEVE[n * n + a * n + b]) {
            n++;
        }
        return n;
    }
}
