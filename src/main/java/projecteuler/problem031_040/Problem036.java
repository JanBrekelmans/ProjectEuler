package projecteuler.problem031_040;

import projecteuler.SolutionTemplate;
import projecteuler.library.Util;

public class Problem036 implements SolutionTemplate {
    private final static int LIMIT = 1_000_000;

    public static void main(String[] args) {
        System.out.println(new Problem036().getSolution());
    }

    @Override
    public String getSolution() {
        int sum = 0;
        for(int i = 1; i < LIMIT; i++) {
            if(Util.isPalindromic(Integer.toString(i)) && Util.isPalindromic(Integer.toBinaryString(i))) sum += i;
        }
        return Integer.toString(sum);
    }
}
