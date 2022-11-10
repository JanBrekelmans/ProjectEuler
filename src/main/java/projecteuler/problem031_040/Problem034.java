package projecteuler.problem031_040;

import projecteuler.SolutionTemplate;
import projecteuler.library.Factorial;

import java.util.Arrays;

public class Problem034 implements SolutionTemplate {
    private final int LIMIT = 2540160; // Largest number we can represent is 7*9!
    private final int[] PRECOMPUTED = new int[10];
    private final int CACHE_SIZE = 1000;
    private final int[] CACHE = new int[CACHE_SIZE];

    public static void main(String[] args) {
        System.out.println(new Problem034().getSolution());
    }

    @Override
    public String getSolution() {
        Arrays.fill(CACHE, -1);
        for(int i = 0; i < 10; i++) {
            PRECOMPUTED[i] = Factorial.factorial(i).intValue();
        }

        int sum = 0;
        for(int i = 3; i <= LIMIT; i++) {
            if(i == getDigitFactorialSum(i)) {
                sum += i;
            }
        }
        return Integer.toString(sum);
    }

    private int getDigitFactorialSum(int n) {
        if(n < CACHE_SIZE) {
            if(CACHE[n] == -1) {
                int sum = 0;
                int m = n;
                while (n > 0) {
                    sum += PRECOMPUTED[n % 10];
                    n /= 10;
                }
                CACHE[m] = sum;
                return sum;
            }
            return CACHE[n];
        }
        return CACHE[n%CACHE_SIZE] + getDigitFactorialSum(n / CACHE_SIZE);
    }
}
