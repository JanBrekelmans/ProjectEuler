package projecteuler.problem021_030;

import projecteuler.SolutionTemplate;
import projecteuler.library.Factorization;

public class Problem021 implements SolutionTemplate {
    private final static int LIMIT = 10_000;

    public static void main(String[] args) {
        System.out.println(new Problem021().getSolution());
    }

    @Override
    public String getSolution() {
        int total = 0;

        for(int i = 2; i < LIMIT; i++) {
            int possibleAmicableCounter = Factorization.getSumOfProperDivisors(i);
            if(i != possibleAmicableCounter && Factorization.getSumOfProperDivisors(possibleAmicableCounter) == i) total += i;
        }

        return Integer.toString(total);
    }
}
