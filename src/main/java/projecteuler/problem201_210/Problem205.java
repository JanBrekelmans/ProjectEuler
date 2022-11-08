package projecteuler.problem201_210;

import projecteuler.SolutionTemplate;
import projecteuler.library.Factorial;

import java.math.BigInteger;
import java.text.Format;
import java.text.Normalizer;

public class Problem205 implements SolutionTemplate {
    int[] numberOfPossibleOutComesPeter = new int[4*9+1];
    int[] numberOfPossibleOutcomesColin = new int[6*6+1];

    public static void main(String[] args) {
        System.out.println(new Problem205().getSolution());
    }

    @Override
    public String getSolution() {
        for(int i = 0; i <= 4*9; i++) {
            numberOfPossibleOutComesPeter[i] = getPossibleWays(4, 9, i);
        }

        for(int i = 0; i <= 6*6; i++) {
            numberOfPossibleOutcomesColin[i] = getPossibleWays(6, 6, i);
        }

        double totalRolls = Math.pow(4, 9) * Math.pow(6,6);
        double validRolls = 0;

        for(int c = 0; c <= 36; c++) {
            for(int p = c+1; p <= 36; p++) {
                validRolls += numberOfPossibleOutcomesColin[c] * numberOfPossibleOutComesPeter[p];
            }
        }

        return String.format("%.7f", validRolls / totalRolls);
    }

    /**
     * Get the total number of possible ways to roll p with n s-sided dice.
     * @param s Number of sides
     * @param n Number of dice
     * @param p Total number rolled
     */
    private int getPossibleWays(int s, int n, int p) {
        BigInteger ways = BigInteger.ZERO;

        for(int k = 0; k <= n; k++) {
            BigInteger t1 = Factorial.binomial(n, k);
            BigInteger t2 = Factorial.binomial(p - s*k - 1, n - 1);

            BigInteger t = t1.multiply(t2);
            if(k%2 == 1) {
                t = t.multiply(BigInteger.valueOf(-1));
            }

            ways = ways.add(t);

            if(p - s*k - n < 0) break;
        }
        return ways.intValue();
    }
}
