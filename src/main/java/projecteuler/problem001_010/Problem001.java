package projecteuler.problem001_010;

import projecteuler.SolutionTemplate;

public class Problem001 implements SolutionTemplate {
    private final static int LIMIT = 1_000;

    public static void main(String[] args) {
        System.out.println(new Problem001().getSolution());
    }

    @Override
    public String getSolution() {
        int sum = 0;
        for (int i = 1; i < LIMIT; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return String.valueOf(sum);
    }
}
