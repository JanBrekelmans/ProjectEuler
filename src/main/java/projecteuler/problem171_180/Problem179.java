package projecteuler.problem171_180;

import projecteuler.SolutionTemplate;

public class Problem179 implements SolutionTemplate {
    private final static int LIMIT = 10_000_000;
    int[] numberOfDivisors = new int[LIMIT+1];

    public static void main(String[] args) {
        System.out.println(new Problem179().getSolution());
    }

    @Override
    public String getSolution() {
        // Fill the number of divisors array
        for(int i = 1; i <= LIMIT; i++) {
            for(int j = i; j <= LIMIT; j += i) {
                numberOfDivisors[j]++;
            }
        }

        int numberOfConsecutiveDivisors = 0;

        for(int i = 1; i < LIMIT; i++) {
            if(numberOfDivisors[i] == numberOfDivisors[i+1]) numberOfConsecutiveDivisors++;
        }

        return Integer.toString(numberOfConsecutiveDivisors);
    }
}
