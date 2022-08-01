package projecteuler.problem001_010;

import projecteuler.SolutionTemplate;

public class Problem006 implements SolutionTemplate {
    private final static int LIMIT = 100;
    public static void main(String[] args) {
        System.out.println(new Problem006().getSolution());
    }
    @Override
    public String getSolution() {
        int sumOfTerms = 0;
        int sumOfSquares = 0;

        for(int i = 1; i <= LIMIT; i++) {
            sumOfTerms += i;
            sumOfSquares += i*i;
        }

        int result = sumOfTerms*sumOfTerms - sumOfSquares;
        return Integer.toString(result);
    }
}
