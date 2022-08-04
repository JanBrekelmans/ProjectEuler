package projecteuler.problem121_130;

import projecteuler.SolutionTemplate;
import projecteuler.library.NumberUtil;
import projecteuler.library.Util;

import java.util.HashSet;
import java.util.Set;

public class Problem125 implements SolutionTemplate {
    private static final int LIMIT = 100_000_000;
    public static void main(String[] args) {
        System.out.println(new Problem125().getSolution());
    }

    @Override
    public String getSolution() {
        Set<Integer> palindromicNumbers = new HashSet<>();

        for(int i = 1; i <= NumberUtil.integerSquareRoot(LIMIT); i++) {
            int sum = i*i;

            for(int j = i+1; j <= LIMIT; j++) {
                sum += j*j;

                if(sum > LIMIT) break;
                if(Util.isPalindromic(sum)) palindromicNumbers.add(sum);
            }
        }

        long total = 0;
        for(int n: palindromicNumbers) total += n;
        return Long.toString(total);
    }
}
